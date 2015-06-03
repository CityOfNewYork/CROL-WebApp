package com.communeup.crol.dao;

import com.communeup.crol.SequenceException;

public interface SequenceDao {

	String getNextSequenceId(String key) throws SequenceException;

}
