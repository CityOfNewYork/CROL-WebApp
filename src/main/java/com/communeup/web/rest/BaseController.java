package com.communeup.web.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class BaseController extends Application {

	protected static final String ITEM = "item";
	protected static final String NOTICE = "notice";

	protected static final String ITEM_CODE = "I";
	protected static final String NOTICE_CODE = "N";

	protected static final String TAG = "T";
	protected static final String PERSON = "P";
	protected static final String SUBJECT = "S";
	protected static final String ADDRESS = "A";
	protected static final String MEETING = "M";
	protected static final String ORGANIZATION = "O";

	protected Logger log = LoggerFactory.getLogger(this.getClass());

	@Context
	protected SecurityContext sc;

	protected String getAuthUserName() {
		return sc.getUserPrincipal().getName();
	}

	public SecurityContext getSc() {
		return sc;
	}

	public void setSc(SecurityContext sc) {
		this.sc = sc;
	}

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();

	@Override
	public Set<Class<?>> getClasses() {
		return empty;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
