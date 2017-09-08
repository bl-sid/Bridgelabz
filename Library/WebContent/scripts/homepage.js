$(document).ready(function() {
			
			//var titleName = "";
			var lastLoadedCategory = "";
			var editBookId = "";
			var user_id = $('#hidden-id-button').val();
			console.log(user_id);
			$('.category').click(function(){
				category = this.innerHTML;
				lastLoadedCategory = category;
				loadCategoryBooks(category);	
				$('#category-data').modal('show');				
			});

			function loadCategoryBooks(category) {
				console.log(category + " " + user_id);
				$.ajax({
					type : "post",
					url : "BookTitleLoader",
					data : {
						category : category,
						user_id : user_id
					},
					success : function(data) {
						$('.category-header').html(category + " Books");
						$('.category-books').html(data);
						refreshClickEvent();
					}
				});
				
			}
			
			
			
			$('#btn-close').click(function(){
				$('#category-data').modal('hide');
			});
			
			$('#btn-add').click(function(){
				$('.add-header').html("Add Book");
				$('#title').val("");
				$('#author').val("");
				$('#categoryid').val("Category");
				$('#price').val("");
				editBookId = "";
				//titleName = "";
				$('#add-data').modal('show'); 
			});
			
			$('#btn-save').click(function(){
				 if(!$('#title').val()){
					alert("Title field is empty");
				} else if(!$('#author').val()){
					alert("Author field is empty");
				}  else if(!$('#categoryid').val()){
					alert("Please select the category of the book");
				}  else if(!$('#price').val()){
					alert("Price field is empty");
				} else{	 	
					console.log("user id " + user_id);
					$.ajax({
						type : "post",
						url : "AddNewBook",
						data: {
							title : $('#title').val(),
							author : $('#author').val(),
							category : $('#categoryid').val(),
							price : $('#price').val(),
							//oldTitle : titleName,
							user_id : user_id,
							book_id : editBookId
						},
						success : function(data) {
							$('#add-data').modal('hide');
							editBookId = "";
							//titleName = "";
						}
					});
				}
				
			});
			
			$('#btn-logout').click(function(){
				$.ajax({
					type : "post",
					url : "LogOut",
					success : function(data){
						window.location = data;
					}
				});
			});
			
			function refreshClickEvent() {

				$("body .book-title").off();

				$("body .book-title").on("click", function() {
					var bookId = $(this).attr('id').replace("title" , "");
					var bookname = $(this).text();
					console.log("book id " + bookId);
					$.ajax({
						type : "post",
						url : "BookDetailsLoader",
						data : {
							book_id : bookId, 
							user_id : user_id
						},
						success : function(data) {
							$('.category-header').html(bookname);
							$('.category-books').html(data);
							console.log("Success in loading" + data);
						}
					});
				});
				
				
				$("body .book-edit").off();

				$("body .book-edit").on("click", function() {
					var bookId = $(this).attr('id').replace('edit', '');
					console.log("Edit clicked on " + bookId + " " + user_id);
					$.ajax({
						type : "post",
						url : "EditBook",
						dataType : "json",
						data : {
							book_id : bookId,
							user_id : user_id
						},
						success : function(data) {
							$('.add-header').html("Edit Book");
							$('#title').val(data.title);
							$('#author').val(data.author);
							$('#categoryid').val(data.category);
							$('#price').val(data.price);
							
							editBookId = bookId;
							
							$('#category-data').modal('hide');
							$('#add-data').modal('show'); 
						}
					});
				});
				
				
				$("body .book-delete").off();

				$("body .book-delete").on("click", function() {
					var bookId = $(this).attr('id').replace('delete', '');
					$.ajax({
						type : "post",
						url : "DeleteBook",
						data : {
							book_id : bookId,
							user_id : user_id
						},
						success : function(data) {
							//$('#category-data').modal('hide');
							loadCategoryBooks(lastLoadedCategory);
							//var myli = $(this).closest('li');
							//myli.hide();
							//console.log("Delete success");
						}
					});
				});
			}
		});