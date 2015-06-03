package com.communeup.web.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;

import com.communeup.crol.domain.Notice;
import com.communeup.crol.to.CrolInput;
import com.communeup.service.CrolService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Controller
@Path("/v12/notice")
@Api(value = "/v12/notice", description = "Commune-Crol Controller")
public class CommuneCrolController extends BaseController {

	private CrolService crolService = new CrolService();

	@GET
	@Path("/{noticeId}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Get Notice using noticeId", notes = "Get Notice using noticeId .")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 500, message = "Something wrong in Server"), @ApiResponse(code = 300, message = "Notice Not found for given noticeId") })
	public String getNotice(@PathParam("noticeId") String noticeId) {
		Notice notice = crolService.fetch(noticeId);

		if (notice != null)
			return notice.getNoticeText();
		else
			return "NOT FOUND";
	}

	@GET
	@Path("/latest/{timestamp}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Get Notice using noticeId", notes = "Get Notice using noticeId .")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 500, message = "Something wrong in Server"), @ApiResponse(code = 300, message = "Notice Not found for given noticeId") })
	public List<String> getNoticesAfter(@PathParam("timestamp") String timestamp) {
		System.out.println("Query by latest timestamp : " + timestamp);
		List<Notice> notices = crolService.fetchAfter(timestamp);

		List<String> texts = new ArrayList<String>();
		for (Notice notice : notices) {
			texts.add(notice.getNoticeText());
		}

		return texts;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Create Notice using given Payload", notes = "Create Notice using given Payload .")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "NOTICE CREATED"), @ApiResponse(code = 500, message = "Something wrong in Server") })
	public Response.Status saveJson(List<CrolInput> notices) {
		try {
			for (CrolInput noticeInput : notices) {
				crolService.parseAndSave(noticeInput);
			}
		} catch (Exception ex) {
			Response.Status.BAD_REQUEST.name();
		}

		return Response.Status.OK;
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Update Notice using noticeId", notes = "Update Notice using noticeId .")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "NOTICE UPDATED"), @ApiResponse(code = 500, message = "Something wrong in Server"), @ApiResponse(code = 300, message = "Notice Not found for given noticeId") })
	public Response.Status updateJson(List<CrolInput> notices) {
		for (CrolInput noticeInput : notices) {
			crolService.parseAndUpdate(noticeInput);
		}

		return Response.Status.OK;
	}

	@DELETE
	@Path("/{noticeId}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Delete Notice using noticeId", notes = "Delete Notice using noticeId .")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "NOTICE DELETED"), @ApiResponse(code = 500, message = "Something wrong in Server"), @ApiResponse(code = 300, message = "Notice Not found for given noticeId") })
	public Response.Status deleteJson(@PathParam("noticeId") String noticeId) {
		crolService.delete(noticeId);
		return Response.Status.OK;
	}

}
