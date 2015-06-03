package com.communeup.crol.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.communeup.crol.SequenceException;
import com.communeup.crol.config.SpringMongoConfig;
import com.communeup.crol.domain.SequenceId;

@Repository
public class SequenceDaoImpl implements SequenceDao {

	@Override
	public String getNextSequenceId(String key) throws SequenceException {

		// get sequence id
		Query query = new Query(Criteria.where("_id").is(key));

		// increase sequence id by 1
		Update update = new Update();
		update.inc("seq", 1);

		// return new increased id
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		if (mongoOperation != null) {
			System.out.println(" Mongo Operations Found ");

			// this is the magic happened.
			SequenceId seqId = mongoOperation.findAndModify(query, update, options, SequenceId.class);

			// if no id, throws SequenceException
			// optional, just a way to tell user when the sequence id is failed to
			// generate.
			if (seqId == null) {
				throw new SequenceException("Unable to get sequence id for key : " + key);
			}

			return seqId.getSeq();
		} else {
			System.out.println("No Mongo Operations Object .. returning 100");
			return "100";
		}
	}

}
