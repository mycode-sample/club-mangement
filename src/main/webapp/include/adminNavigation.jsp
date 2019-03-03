<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="col-lg-2">
				<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingOne">
							<h4 class="panel-title">
								<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
									<font class="text-info">学生管理</font>
								</a>
							</h4>
							<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
							  <div class="panel-body">
								<ul class="nav nav-pills nav-stacked" style="width:100px">
								  <li role="presentation"><a href="/club-mangement/Admin?type=retrieveStudent" class="text-primary">学生列表</a></li>
								  <li role="presentation"><a href="/club-mangement/Admin?type=retrieveDepartment" class="text-primary">学院列表</a></li>
								  <li role="presentation"><a href="/club-mangement/Admin?type=retrieveProfession" class="text-primary">专业列表</a></li>
								</ul>
								</ul>
							  </div>
							</div>
						</div>
					</div>
				</div>
				<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingTwo">
							<h4 class="panel-title">
								<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
									<font class="text-info">个人中心</font>
								</a>
							</h4>
							<div id="collapseTwo" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingTwo">
							  <div class="panel-body">
								<ul class="nav nav-pills nav-stacked" style="width:100px">
								  <li role="presentation"><a href="/club-mangement/Admin?type=updatePassword" class="text-primary">修改密码</a></li>
								  <li role="presentation"><a href="/club-mangement/Admin?type=updateUsername" class="text-primary">修改用户名</a></li>
								</ul>
							  </div>
							</div>
						</div>
					</div>
				</div>
			</div>