 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


</head>
<body>
 <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
          <div class="row">
            <div class="col-sm-12">
              <div class="home-tab">
                <div class="d-sm-flex align-items-center justify-content-between border-bottom">
                  <ul class="nav nav-tabs" role="tablist">
                    <li class="nav-item">
                      <a class="nav-link active ps-0" id="home-tab" data-bs-toggle="tab" href="#overview" role="tab" aria-controls="overview" aria-selected="true">tổng quan</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" id="profile-tab" data-bs-toggle="tab" href="#audiences" role="tab" aria-selected="false">thống kê</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" id="contact-tab" data-bs-toggle="tab" href="#demographics" role="tab" aria-selected="false">thông báo</a>
                    </li>
                    <li class="nav-item">
                     		 <a class="nav-link border-0" id="more-tab" data-bs-toggle="tab" href="" role="tab" aria-selected="false">hơn nữa</a>
                      	
                    </li>
                  </ul>
                  <div>
                    <div class="btn-wrapper">
                      <a href="#" class="btn btn-otline-dark align-items-center"><i class="icon-share"></i> Share</a>
                      <a href="#" class="btn btn-otline-dark"><i clastabs="icon-printer"></i> Print</a>
                      <form method="post" action="/shopvnua/exportproduct" id="myform">
                      		<a href="#" class="btn btn-primary text-white me-0" onclick="document.getElementById('myform').submit()"><i class="icon-download" onclick="document.getElementById('myform').submit()"></i> xuất file</a>
                      </form>
                    </div>
                  </div>
                </div>
                <div class="tab-content tab-content-basic">
                  <div class="tab-pane fade show active" id="overview" role="tabpanel" aria-labelledby="overview"> 
                    <div class="row">
                      <div class="col-sm-12">
                        <div class="statistics-details d-flex align-items-center justify-content-between">
                          <div>
                            <p class="statistics-title">tài nguyên</p>
                            <h3 class="rate-percentage">32.53%</h3>
                            <p class="text-danger d-flex"><i class="mdi mdi-menu-down"></i><span>-0.5%</span></p>
                          </div>
                          <div>
                            <p class="statistics-title">lượt xem</p>
                            <h3 class="rate-percentage">7,682</h3>
                            <p class="text-success d-flex"><i class="mdi mdi-menu-up"></i><span>+0.1%</span></p>
                          </div>
                          <div>
                            <p class="statistics-title">lượt đăng nhập</p>
                            <h3 class="rate-percentage">68.8</h3>
                            <p class="text-danger d-flex"><i class="mdi mdi-menu-down"></i><span>68.8</span></p>
                          </div>
                          <div class="d-none d-md-block">
                            <p class="statistics-title">thời gian onlien</p>
                            <h3 class="rate-percentage">2m:35s</h3>
                            <p class="text-success d-flex"><i class="mdi mdi-menu-down"></i><span>+0.8%</span></p>
                          </div>
                          <div class="d-none d-md-block">
                            <p class="statistics-title">session mới</p>
                            <h3 class="rate-percentage">68.8</h3>
                            <p class="text-danger d-flex"><i class="mdi mdi-menu-down"></i><span>68.8</span></p>
                          </div>
                          <div class="d-none d-md-block">
                            <p class="statistics-title">thời gian onlien</p>
                            <h3 class="rate-percentage">2m:35s</h3>
                            <p class="text-success d-flex"><i class="mdi mdi-menu-down"></i><span>+0.8%</span></p>
                          </div>
                        </div>
                      </div>
                    </div> 
                    <div class="row">
                      <div class="col-lg-8 d-flex flex-column">
  
                        <div class="row flex-grow">
                          <div class="col-12 grid-margin stretch-card">
                            <div class="card card-rounded">
                              <div class="card-body">
                                <div class="d-sm-flex justify-content-between align-items-start">
                                  <div>
                                    <button class="btn btn-primary btn-lg text-white mb-0 me-0" type="button" data-toggle="modal" data-target="#exampleModalLong"><i class="mdi mdi-account-plus" data-toggle="modal" data-target="#exampleModal"></i>Add new member</button>
                                  </div>
                                </div>
                                <div class="table-responsive  mt-1">
                                  <table class="table select-table">
                                    <thead>
                                      <tr>
                                        <th>ảnh</th>
                                        <th>ngày sinh</th>
                                        <th>hiệu suất làm việc</th>
                                        <th>ngày tham gia</th>
                                        <th></th>
                                      </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${listemployee}" var="lep">
                                      <tr>
                                        <td>
                                          <div class="d-flex">
                                            <img src="${lep.avatar}" alt="">
                                            <div>
                                              <h6>${lep.name}</h6>
                                              <p>ten user</p>
                                            </div>
                                          </div>
                                        </td>
                                        <td>
                                          <h6>${lep.birthday}</h6>
                                          <p>${lep.caculateAge()} tuổi</p>
                                        </td>
                                        <td>
                                          <div>
                                            <div class="d-flex justify-content-between align-items-center mb-1 max-width-progress-wrap">
                                              <p class="text-success">65%</p>
                                              <p>85/162</p>
                                            </div>
                                            <div class="progress progress-md">
                                              <div class="progress-bar bg-success" role="progressbar" style="width: 65%" aria-valuenow="65" aria-valuemin="0" aria-valuemax="100"></div>
                                            </div>
                                          </div>
                                        </td>
                                        <td><div class="badge badge-opacity-success">${lep.createdate}</div></td>
                                         <div class="progress progress-md">
                                        <td>
                                       <c:if test="${Role == true}">
											<a href="deleteemp?id=${lep.id}" title="Delete"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16"><path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/><path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/></svg></a>
										</c:if>
										</td>
                                        </div>
                                      </tr>
                                      </c:forEach>
                                    </tbody>
                                  </table>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                        
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- main-panel ends -->
    </div>
  
           <!-- Button trigger modal -->

<!-- Modal -->
<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
         <div class="col-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Basic form elements</h4>
                  <p class="card-description">
                    Basic form elements
                  </p>
                  <form class="forms-sample" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                      <label for="exampleInputName1">Name</label>
                      <input type="text" class="form-control" id="exampleInputName1" placeholder="Name">
                    </div>
                    <div class="form-group">
                      <label for="exampleInputEmail3">Email address</label>
                      <input type="email" class="form-control" id="exampleInputEmail3" placeholder="Email">
                    </div>
                    <div class="form-group">
                      <label for="exampleInputPassword4">Password</label>
                      <input type="password" class="form-control" id="exampleInputPassword4" placeholder="Password">
                    </div>
                    <div class="form-group">
                      <label for="exampleSelectGender">Gender</label>
                        <select class="form-control" id="exampleSelectGender">
                          <option>Male</option>
                          <option>Female</option>
                        </select>
                      </div>
                    <div class="form-group">
                      <label>avatar</label>
                      <input type="file" name="image" multiple="multiple">
                    </div>
                    <div class="form-group">
                      <label for="exampleInputCity1">City</label>
                      <input type="text" class="form-control" id="exampleInputCity1" placeholder="Location">
                    </div>
                    <div class="form-group">
                      <label for="exampleTextarea1">Textarea</label>
                      <textarea class="form-control" id="exampleTextarea1" rows="4"></textarea>
                    </div>
                    <!-- <button type="submit" class="btn btn-primary me-2">Submit</button>
                    <button class="btn btn-light">Cancel</button> -->
                 
                </div>
              </div>
            </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
         </form>
      </div>
    </div>
  </div>
</div>

    </body>
    </html>