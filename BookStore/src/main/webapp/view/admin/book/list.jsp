<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-book" />
<c:url var="Bookurl" value="/admin-book-list" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List book</title>
</head>
<body>
<div class="main-content">
		<form style="" action="<c:url value='/admin-book-list'/>" id="formSubmit"
			method="get">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="<c:url value='/admin-home'/>" >Home</a>
						</li>
						<li class="active">Dashboard</li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<a flag="info" class="btn btn-light btn-bold text-dark"
								data-toggle="tooltip" title="Thêm bài viết"
								href="<c:url value='/admin-book-list?type=edit'/>"><span><i
									class="fa fa-plus-circle" aria-hidden="true"></i></span></a>
							<button id="btnDelete" type="button" class="btn btn-light btn-bold text-dark"
								data-toggle="tooltip" title="Xoá bài viết">
								<span><i class="fa fa-trash-o" aria-hidden="true"></i> </span>
							</button>
						</div>
					</div>
					<c:if test="${not empty message}">
							<div class="alert alert-${alert}">${message}</div>
							<input
						type="hidden" value="" id="message" name="message" /> <input
						type="hidden" value="" id="alert" name="alert" />
						</c:if>
					<div class="row">
						<div class="col-xs-12">
							<div class="table-responsive">
								<table class="table table-bordered">
									<thead>
										<tr>
											<th><input type="checkbox" id="checkAll" /></th>
											<th>Title</th>
											<th>Price</th>
											<th>Description</th>
											<th>Thumbnail</th>
											<th>Quantity</th>
											<th>Edit</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${model.modelList}">
											<tr>
												<td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"/></td>
												<td>${item.title}</td>
												<td>${item.price}đ</td>
												<td>${item.description}</td>
												<td>${item.thumbnail}</td>
												<td>${item.quantity}</td>
												<td><a href="<c:url value='/admin-book-list?type=edit&id=${item.id}'/> "><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
												</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<ul class="pagination" id="pagination"></ul>
					<input type="hidden" value="" id="cPage" name="cPage" /> <input
						type="hidden" value="" id="dPage" name="dPage" /> <input
						type="hidden" value="" id="sortName" name="sortName" /> <input
						type="hidden" value="" id="sortBy" name="sortBy" /> <input
						type="hidden" value="" id="type" name="type" /> 
				</div>
			</div>
		</form>
	</div>
	
	<script type="text/javascript">
		var tPages = ${model.tPages};
		var cPage = ${model.cPage};
		var limit = 5;
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : tPages,
				visiblePages : 5,
				startPage : cPage,
				onPageClick : function(event, page) {
					if (cPage != page) {
						$('#dPage').val(limit);
						$('#cPage').val(page);
						$('#sortName').val("title");
						$('#sortBy').val("ASC");
						$('#type').val("list");
						$('#formSubmit').submit();
					}
				}
			});
		});

		$('#btnDelete').click(function() {
			var data={};
			var ids = $('tbody input[type=checkbox]:checked').map(function() {
				return $(this).val();
			}).get();
			data['ids'] = ids;
			deleteNew(data);
		});

		function deleteNew(data) {
			$.ajax({
				url : '${APIurl}',
				type : 'DELETE',
				contentType : 'application/json',
				data : JSON.stringify(data),
				success : function(result) {
					console.log(result);
					$(location).attr('href','${Bookurl}?cPage=1&dPage=5&sortName=title&sortBy=ASC&type=list');
				},
				error : function(error) {
					console.log(error);
					$(location).attr('href','${Bookurl}?cPage=1&dPage=5&sortName=title&sortBy=ASC&type=list&message=error-system&alert=danger');
				}

			});
		};
	</script>
</body>
</html>