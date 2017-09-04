$(document).ready(function() {
			
			var titleName = "";
			$('.category').click(function() {
				var category = this.innerHTML;

				$.ajax({
					type : "get",
					url : "BookTitleLoader",
					data : "category=" + category,
					success : function(data) {
						$('.category-header').html(category + " Books");
						$('.category-books').html(data);
						$('#category-data').modal('show');
						refreshClickEvent();
					}
				});
			});

			$('#btn-close').click(function(){
				$('#category-data').modal('hide');
			});
			
			$('#btn-add').click(function(){
				$('.add-header').html("Add Book");
				$('#title').val("");
				$('#author').val("");
				$('#categoryid').val("Category");
				$('#price').val("");
				titleName = "";
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
					$.ajax({
						type : "post",
						url : "AddNewBook",
						data: {
							title : $('#title').val(),
							author : $('#author').val(),
							category : $('#categoryid').val(),
							price : $('#price').val(),
							oldTitle : titleName
						},
						success : function(data) {
							$('#add-data').modal('hide');
							titleName = "";
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
					var bookname = $(this).text();

					$.ajax({
						type : "get",
						url : "BookDetailsLoader",
						data : "title=" + bookname,
						success : function(data) {
							$('.category-header').html(bookname);
							$('.category-books').html(data);
						}
					});
				});
				
				
				$("body .book-edit").off();

				$("body .book-edit").on("click", function() {
					var bookname = $(this).attr('class');
					bookname = bookname.replace("form-pull-right book-edit ", "");
					$.ajax({
						type : "get",
						url : "EditBook",
						dataType : "json",
						data : "title=" + bookname,
						success : function(data) {
							titleName = data.title;
							$('.add-header').html("Edit Book");
							$('#title').val(data.title);
							$('#author').val(data.author);
							$('#categoryid').val(data.category);
							$('#price').val(data.price);
							$('#category-data').modal('hide');
							$('#add-data').modal('show'); 
						}
					});
				});
				
				
				$("body .book-delete").off();

				$("body .book-delete").on("click", function() {
					var bookname = $(this).attr('class');
					bookname = bookname.replace("close book-delete ", "");
					$.ajax({
						type : "get",
						url : "DeleteBook",
						data : "title=" + bookname,
						success : function(data) {
							$('#category-data').modal('hide');
						}
					});
				});
			}
		});