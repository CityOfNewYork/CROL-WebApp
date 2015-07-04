package com.communeup.web.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Get Notice using last request time", notes = "Get Notice using last request time .")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Something wrong in Server"),
			@ApiResponse(code = 300, message = "Notice Not found for given noticeId") })
	public Response getNoticeQueryParam(
			@QueryParam("lastRequestDate") String lastRequestDate, @QueryParam("noticeId") String noticeId) {
		if (lastRequestDate != null) {
			return getNoticesAfter(lastRequestDate);
		}

		if (noticeId != null) {
			Notice notice = getNoticeForId(noticeId);

			if (notice != null) {
				return Response.status(Status.OK).entity(notice.getNoticeText()).build();
			}
		}

		return Response.status(Status.BAD_REQUEST).entity("Notice Id doesn't Exist ").build();
	}

	private Notice getNoticeForId(String noticeId) {
		return crolService.fetch(noticeId);
	}

	private Response getNoticesAfter(String timestamp) {
		StringBuffer buffer = new StringBuffer("[");

		List<Notice> notices = crolService.fetchAfter(timestamp);

		if (notices.size() == 0) {
			return Response.status(Status.BAD_REQUEST).entity("No Notices Found after the given Date : " + timestamp).build();
		}

		int count = 0;
		for (Notice notice : notices) {
			if (notice.getNoticeText() != null) {
				if (count++ >= 1) {
					buffer.append("\n,\n");
				}
				buffer.append(notice.getNoticeText());
			}
		}
		buffer.append("]");

		return Response.status(200).entity(buffer.toString()).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Create Notice using given Payload", notes = "Create Notice using given Payload .")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "NOTICE CREATED"),
			@ApiResponse(code = 400, message = "Something wrong in Server") })
	public Response saveJson(List<CrolInput> notices) {
		try {
			for (CrolInput noticeInput : notices) {
				Notice notice = getNoticeForId(noticeInput.getRequestId());

				if (notice != null) {
					crolService.delete(noticeInput.getRequestId());
				}

				crolService.parseAndSave(noticeInput);
			}
		} catch (Exception ex) {
			return Response.status(Status.BAD_REQUEST).entity("Invalid JSON : " + ex.getMessage()).build();
		}

		return Response.status(Status.OK).entity("Notice(s) Successfully Added.").build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Update Notice using noticeId", notes = "Update Notice using noticeId .")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "NOTICE UPDATED"),
			@ApiResponse(code = 400, message = "Something wrong in Server"),
			@ApiResponse(code = 300, message = "Notice Not found for given noticeId") })
	public Response updateJson(List<CrolInput> notices) {
		try {
			for (CrolInput noticeInput : notices) {
				crolService.parseAndUpdate(noticeInput);
			}
		} catch(Exception ex) {
			return Response.status(Status.BAD_REQUEST).entity("Invalid JSON : " + ex.getMessage()).build();
		}

		return Response.status(Status.OK).entity("Notice Updated.").build();
	}

	@DELETE
	@Path("/{noticeId}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Delete Notice using noticeId", notes = "Delete Notice using noticeId .")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "NOTICE DELETED"),
			@ApiResponse(code = 400, message = "Something wrong in Server"),
			@ApiResponse(code = 300, message = "Notice Not found for given noticeId") })
	public Response deleteJson(@PathParam("noticeId") String noticeId) {
		try {
			crolService.delete(noticeId);
		} catch (Exception ex) {
			return Response.status(Status.BAD_REQUEST).entity("Invalid JSON : " + ex.getMessage()).build();
		}

		return Response.status(Status.OK).entity("Notice Deleted.").build();
	}

}
