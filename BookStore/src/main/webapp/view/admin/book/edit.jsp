<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-book" />
<c:url var="Bookurl" value="/admin-book-list" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="<c:url value='/admin-home'/>">Home</a>
					</li>
					<li><a
						href="<c:url value='/admin-book-list?cPage=1&dPage=5&sortName=title&sortBy=ASC&type=list'/> ">Dashboard</a></li>
					<li class="active">Edit new</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<c:if test="${not empty message}">
							<div class="alert alert-${alert}">${message}</div>
						</c:if>
						<form id="formSubmit">
							<div class="form-group d-flex align-items-center"
								style="padding: 16px 0">
								<label
									class="col-sm-3 control-label no-padding-right d-flex align-items-center"
									style="padding: 6px 0">Category: </label>
								<div class="col-sm-9">
									<select class="form-control" id="categoryCode"
										name="categoryCode">
										<c:if test="${empty model.categoryCode}">
											<option value="">Category</option>
											<c:forEach var="item" items="${categories}">
												<option value="${item.code}">${item.name}</option>
											</c:forEach>
										</c:if>
										<c:if test="${not empty model.categoryCode}">
											<option value="">Choose category</option>
											<c:forEach var="item" items="${categories}">
												<option value="${item.code}"
													<c:if test="${item.code == model.categoryCode}">selected="selected"</c:if>>${item.name}</option>
											</c:forEach>
										</c:if>
									</select>
								</div>
							</div>
							<div class="form-group d-flex align-items-center"
								style="padding: 16px 0">
								<label class="col-sm-3 d-flex align-items-center"
									style="padding: 6px 0">Title: </label>
								<div class="col-sm-9">
									<input type="text" name="title" class="form-control" id="title"
										value="${model.title}" />
								</div>
							</div>
							<div class="form-group d-flex align-items-center"
								style="padding: 16px 0">
								<label class="col-sm-3 d-flex align-items-center"
									style="padding: 6px 0">Price: </label>
								<div class="col-sm-9">
									<input type="text" name="price" class="form-control" id="price"
										value="${model.price}" />
								</div>
							</div>
							<div class="form-group d-flex align-items-center"
								style="padding: 16px 0">
								<label class="col-sm-3 d-flex align-items-center"
									style="padding: 6px 0">Thumbnail: </label>
								<div class="col-sm-9">
									<input type="text" name="thumbnail" class="form-control" id="thumbnail"
										value="${model.thumbnail}" />
								</div>
							</div>
							<div class="form-group d-flex align-items-center"
								style="padding: 16px 0">
								<label class="col-sm-3 d-flex align-items-center"
									style="padding: 6px 0">Description: </label>
								<div class="col-sm-9">
									<input type="text" name="description" class="form-control" id="description"
										value="${model.description}" />
								</div>
							</div>
							<div class="form-group d-flex align-items-center"
								style="padding: 16px 0">
								<label class="col-sm-3 d-flex align-items-center"
									style="padding: 6px 0">Quantity: </label>
								<div class="col-sm-9">
									<input type="text" name="quantity" class="form-control" id="quantity"
										value="${model.quantity}" />
								</div>
							</div>
							<div class="form-group d-flex align-items-center"
								style="padding: 32px 0">
								<c:if test="${empty model.id}">
									<input class="btn-success" style="padding: 4px 16px; float: right; margin-right: 20px"
										type="button" value="Add" id="btnAddOrUpdateNew">
								</c:if>
								<c:if test="${not empty model.id}">
									<input class="btn-success" style="padding: 4px 16px; float: right; margin-right: 20px"
										type="button" value="Update" id="btnAddOrUpdateNew">
								</c:if>
							</div>
							<input type="hidden" id="id" name="id" value="${model.id}" />
						</form>
						<input type="hidden" id="alert" name="alert" value="" />
						<input type="hidden" id="message" name="message" value="" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
	$('#btnAddOrUpdateNew').click(function(e) {
		e.preventDefault();
		var data = {};
		var formData = $('#formSubmit').serializeArray();
		$.each(formData, function(i, v) {
			data[""+v.name+""]=v.value;
		})
		var id = $('#id').val();
		if(id == "") {
			addNew(data);
		}else {
			updateNew(data);
		}

		function addNew(data) {
			$.ajax({
				url: '${APIurl}',
				type: 'POST',
				contentType: 'application/json',
				data: JSON.stringify(data),
				dataType: 'json',
				success: function(result) {
					$(location).attr("href", "${Bookurl}?type=edit&id="+result.id+"&message=add-success&alert=success");
				},
				error: function(error) {
					$(location).attr("href", "${Bookurl}?type=edit&message=error-system&alert=danger");
				}
			})			
		}
		function updateNew(data) {
			$.ajax({
				url: '${APIurl}',
				type: 'PUT',
				contentType: 'application/json',
				data: JSON.stringify(data),
				dataType: 'json',
				success: function(result) {
					$(location).attr("href", "${Bookurl}?type=edit&id="+result.id+"&message=update-success&alert=success");
				},
				error: function(error) {
					$(location).attr("href", "${Bookurl}?type=edit&message=error-system&alert=danger");
				}
			})
		}
	});
</script>
</body>
</html>