package com.bridgelabz;

public class CreateModal {

	StringBuilder modalLinkString = new StringBuilder();
	StringBuilder modalString = new StringBuilder();
	public String modalLink(Book book){
		String title = book.getTitle();
		modalLinkString.append("<li>");
		modalLinkString.append("<a data-toggle='modal' href='#" + title + "'" + "data-target='#" + title + "'" + " data-toggle='modal' >" + title + "</a>");
		modalLinkString.append("<button type='button' class='close' data-dismiss='modal'>&times;</button>");
		modalLinkString.append("<a href='#' class='form-pull-right'>edit</a>");
		modalLinkString.append("</li>");
		return modalLinkString.toString();
	}
	
	public String modal(Book book){
		modalString.append("<div class='modal fade' id='Cosmos' tabindex='-1'>"+
		"<div class='modal-dialog'>"+
			"<div class='modal-content'>"+
					"<div class='modal-header'>"+
						"<h4 class='modal-title'>Add Book</h4>"+
					"</div>"+
					"<div class='modal-body'>"+						
					"</div>"+
					"<div class='modal-footer'>"+
						"<button type='button' class='btn btn-primary btn-sm'"+
							"data-dismiss='modal'>Cancel</button>"+
						"<input type='submit' class='btn btn-primary btn-sm' value='Save'>"+
					"</div>"+
			"</div>"+
		"</div>"+
	"</div>");
		return modalString.toString();
	}
}
