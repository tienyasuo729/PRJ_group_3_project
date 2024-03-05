<%-- 
    Document   : head
    Created on : Mar 4, 2024, 9:56:20 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="UTF-8"><style data-styles="">ion-icon{visibility:hidden}.hydrated{visibility:inherit}</style>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Giao Hàng Tiện Lợi</title>

        <link rel="stylesheet" type="text/css" href="Style/vendor.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

        <link rel="stylesheet" type="text/css" href="Style/style.css">

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin="">
        <link href="https://fonts.googleapis.com/css2?family=Jost&amp;family=Roboto:wght@400;700&amp;display=swap" rel="stylesheet">

        <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule="" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

        <!-- script ================================================== -->
        <script src="js/modernizr.js"></script>

    </head>
    <body>
        <section id="navigation-bar" class="navigation position-fixed">

    <nav id="navbar-example2" class="navbar navbar-expand-lg">

      <div class="navigation container-fluid d-flex flex-wrap align-items-center my-2 pe-4 ps-5 ">

        <div class="col-md-3 brand-logo">
          <a href="index.html" class="d-inline-flex link-body-emphasis text-decoration-none">
                <img class="col-md-6" src="images/logoPage.png" alt=""  width="100" height="93">
                <img class="col-md-6" src="images/LogoTitel.png" alt="alt" width="100" height="93" />
          </a>
        </div>

        <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar2" aria-controls="offcanvasNavbar2" aria-label="Toggle navigation"><ion-icon name="menu-outline" role="img" class="md hydrated"></ion-icon></button>

        <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar2" aria-labelledby="offcanvasNavbar2Label">

          <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="offcanvasNavbar2Label">Menu</h5>
            <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
          </div>

          <div class="offcanvas-body">
            <ul class="navbar-nav align-items-center flex-grow-1">
              <li class="nav-list mx-3">
                <a href="index.html" class="nav-link px-2">
                  <h5> Home </h5>
                </a>
              </li>
              <li class="nav-list mx-3">
                <a href="#resources" class="nav-link px-2">
                  <h5> About us </h5>
                </a>
              </li>
              <li class="nav-list mx-3">
                <a href="#services" class="nav-link px-2">
                  <h5> dịch vụ </h5>
                </a>
              </li>
              <li class="nav-list mx-3">
                <a href="#articles" class="nav-link px-2">
                  <h5> Blog </h5>
                </a>
              </li>
              <li class="nav-list mx-3">
                <a href="#contact" class="nav-link px-2">
                  <h5> Contact </h5>
                </a>
              </li>
              
             
            </ul>

            <div class="account d-flex align-items-center mt-5 mt-lg-0 justify-content-center justify-content-lg-end">
              <a href="#" class="nav-link me-5 login" data-bs-toggle="modal" data-bs-target="#exampleModal">
                <h5>Login</h5>
              </a>
              <!-- Modal -->
              <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                  <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                      <div class="tabs-listing">
                        <nav>
                          <div class="nav nav-tabs d-flex justify-content-center border-0" id="nav-tab" role="tablist">
                            <button class="btn btn-outline-primary text-uppercase px-4 py-2 me-4 active" id="nav-sign-in-tab" data-bs-toggle="tab" data-bs-target="#nav-sign-in" type="button" role="tab" aria-controls="nav-sign-in" aria-selected="true">Log
                              In</button>
                            <button class="btn btn-outline-primary text-uppercase px-4 py-2" id="nav-register-tab" data-bs-toggle="tab" data-bs-target="#nav-register" type="button" role="tab" aria-controls="nav-register" aria-selected="false" tabindex="-1">Sign
                              Up</button>
                          </div>
                        </nav>
                        <div class="tab-content" id="nav-tabContent">
                          <div class="tab-pane fade active show" id="nav-sign-in" role="tabpanel" aria-labelledby="nav-sign-in-tab">
                            <form id="form1" class="form-group flex-wrap p-3 ">
                              <div class="form-input col-lg-12 my-4">
                                <label for="exampleInputEmail1" class="form-label fs-6 text-uppercase fw-bold text-black">Email
                                  Address</label>
                                <input type="text" id="exampleInputEmail1" name="email" placeholder="Email" class="form-control ps-3">
                              </div>
                              <div class="form-input col-lg-12 my-4">
                                <label for="inputPassword1" class="form-label  fs-6 text-uppercase fw-bold text-black">Password</label>
                                <input type="password" id="inputPassword1" placeholder="Password" class="form-control ps-3" aria-describedby="passwordHelpBlock">
                                <div id="passwordHelpBlock" class="form-text text-center">
                                  <a href="#" class=" password">Forgot Password ?</a>
                                </div>

                              </div>
                              <label class="py-3">
                                <input type="checkbox" required="" class="d-inline">
                                <span class="label-body text-black">Remember Me</span>
                              </label>
                              <div class="d-grid my-3">
                                <button class="btn btn-primary btn-lg btn-dark text-uppercase btn-rounded-none fs-6">Log
                                  In</button>
                              </div>
                            </form>
                          </div>
                          <div class="tab-pane fade" id="nav-register" role="tabpanel" aria-labelledby="nav-register-tab">
                            <form id="form2" class="form-group flex-wrap p-3 ">
                              <div class="form-input col-lg-12 my-4">
                                <label for="exampleInputEmail2" class="form-label fs-6 text-uppercase fw-bold text-black">Email
                                  Address</label>
                                <input type="text" id="exampleInputEmail2" name="email" placeholder="Email" class="form-control ps-3">
                              </div>
                              <div class="form-input col-lg-12 my-4">
                                <label for="inputPassword2" class="form-label  fs-6 text-uppercase fw-bold text-black">Password</label>
                                <input type="password" id="inputPassword2" placeholder="Password" class="form-control ps-3" aria-describedby="passwordHelpBlock">
                              </div>
                              <label class="py-3">
                                <input type="checkbox" required="" class="d-inline">
                                <span class="label-body text-black">I agree to the <a href="#" class="text-black password border-bottom">Privacy
                                    Policy</a>
                                </span>
                              </label>
                              <div class="d-grid my-3">
                                <button class="btn btn-primary btn-lg btn-dark text-uppercase btn-rounded-none fs-6">Sign
                                  Up</button>
                              </div>
                            </form>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <button type="button" class="btn btn-primary first-button signup px-4 py-3" data-bs-toggle="modal" data-bs-target="#exampleModal2">Sign up</button>
              <!-- Modal -->
              <div class="modal fade" id="exampleModal2" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                  <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                      <div class="tabs-listing">
                        <nav>
                          <div class="nav nav-tabs d-flex justify-content-center border-0" id="nav-tab2" role="tablist">
                            <button class="btn btn-outline-primary text-uppercase px-4 py-2 me-4 " id="nav-sign-in-tab2" data-bs-toggle="tab" data-bs-target="#nav-sign-in2" type="button" role="tab" aria-controls="nav-sign-in2" aria-selected="false" tabindex="-1">Log
                              In</button>
                            <button class="btn btn-outline-primary text-uppercase px-4 py-2 active" id="nav-register-tab2" data-bs-toggle="tab" data-bs-target="#nav-register2" type="button" role="tab" aria-controls="nav-register2" aria-selected="true">Sign
                              Up</button>
                          </div>
                        </nav>
                        <div class="tab-content" id="nav-tabContent1">
                          <div class="tab-pane fade " id="nav-sign-in2" role="tabpanel" aria-labelledby="nav-sign-in-tab2">
                            <form id="form3" class="form-group flex-wrap p-3 ">
                              <div class="form-input col-lg-12 my-4">
                                <label for="exampleInputEmail3" class="form-label fs-6 text-uppercase fw-bold text-black">Email
                                  Address</label>
                                <input type="text" id="exampleInputEmail3" name="email" placeholder="Email" class="form-control ps-3">
                              </div>
                              <div class="form-input col-lg-12 my-4">
                                <label for="inputPassword3" class="form-label  fs-6 text-uppercase fw-bold text-black">Password</label>
                                <input type="password" id="inputPassword3" placeholder="Password" class="form-control ps-3" aria-describedby="passwordHelpBlock">
                                <div id="passwordHelpBlock2" class="form-text text-center">
                                  <a href="#" class=" password">Forgot Password ?</a>
                                </div>

                              </div>
                              <label class="py-3">
                                <input type="checkbox" required="" class="d-inline">
                                <span class="label-body text-black">Remember Me</span>
                              </label>
                              <div class="d-grid my-3">
                                <button class="btn btn-primary btn-lg btn-dark text-uppercase btn-rounded-none fs-6">Log
                                  In</button>
                              </div>
                            </form>
                          </div>
                          <div class="tab-pane fade active show" id="nav-register2" role="tabpanel" aria-labelledby="nav-register-tab2">
                            <form id="form4" class="form-group flex-wrap p-3 ">
                              <div class="form-input col-lg-12 my-4">
                                <label for="exampleInputEmail4" class="form-label fs-6 text-uppercase fw-bold text-black">Email
                                  Address</label>
                                <input type="text" id="exampleInputEmail4" name="email" placeholder="Email" class="form-control ps-3">
                              </div>
                              <div class="form-input col-lg-12 my-4">
                                <label for="inputPassword4" class="form-label  fs-6 text-uppercase fw-bold text-black">Password</label>
                                <input type="password" id="inputPassword4" placeholder="Password" class="form-control ps-3" aria-describedby="passwordHelpBlock">
                              </div>
                              <label class="py-3">
                                <input type="checkbox" required="" class="d-inline">
                                <span class="label-body text-black">I agree to the <a href="#" class="text-black password border-bottom">Privacy
                                    Policy</a>
                                </span>
                              </label>
                              <div class="d-grid my-3">
                                <button class="btn btn-primary btn-lg btn-dark text-uppercase btn-rounded-none fs-6">Sign
                                  Up</button>
                              </div>
                            </form>
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

    </nav>

  </section>
    </body>
</html>
