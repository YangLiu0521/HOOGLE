<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <!-- page title -->
    <title>
      Stetho - Hotel Multipage Clean Bootstrap HTML5 Website Template
    </title>
    <!-- favicon -->
    <link rel="icon" href="favicon.ico" />
    <!-- bootstrap core CSS -->
    <link rel="stylesheet" href="/HOOGLE/datetimepicker/css/bootstrap.min.css" />
    <!-- font awesome -->
    <link href="/HOOGLE/datetimepicker/css/all.min.css" rel="stylesheet" />
    <!-- owl carousel -->
    <link href="/HOOGLE/datetimepicker/css/owl.carousel.min.css" rel="stylesheet" />
    <link href="/HOOGLE/datetimepicker/css/owl.theme.default.min.css" rel="stylesheet" />
    <!-- venobox css -->
    <link rel="stylesheet" href="/HOOGLE/datetimepicker/css/venobox.css" />
    <!-- datepicker css -->
    <link rel="stylesheet" href="/HOOGLE/datetimepicker/css/datepicker.min.css" />
    <!-- custom styles for this template -->
    <link href="/HOOGLE/datetimepicker/css/custom.css" rel="stylesheet" />
    <link href="/HOOGLE/datetimepicker/css/responsive.css" rel="stylesheet" />
    <link href="/HOOGLE/datetimepicker/css/helper.css" rel="stylesheet" />
  </head>

  <body>
    <!-- ================ Preloader ================ -->
<!--     <div id="preloader"> -->
<!--       <div class="spinner-grow" role="status"> -->
<!--         <span class="sr-only">Loading...</span> -->
<!--       </div> -->
<!--     </div> -->
    <!-- ================ Preloader end ================ -->

    <!-- ================ Header ================ -->
    <header class="header">
      <!-- header upper -->
      <div class="header-upper-bar">
        <div class="container">
          <div class="row d-flex align-items-center">
            <div class="col-lg-8 col-md-6 col-sm-4 col-2">
              <!-- header navigation -->
              <nav class="navbar header-navigation navbar-expand-lg p-0">
                <!-- mobile Toggle -->
                <button
                  class="navbar-toggler"
                  type="button"
                  data-toggle="collapse"
                  data-target="#navbarTheme"
                  aria-controls="navbarTheme"
                  aria-expanded="false"
                  aria-label="Toggle navigation"
                >
                  <span></span> <span></span> <span></span>
                </button>
                <!-- mobile toggle end -->
                <!-- top Menu -->
                <div class="collapse navbar-collapse" id="navbarTheme">
                  <ul
                    class="navbar-nav align-items-start align-items-lg-center"
                  >
                    <li><a class="nav-link" href="index.jsp">Home</a></li>
                    <li><a class="nav-link" href="about.jsp">About Us</a></li>
                    <li><a class="nav-link" href="gallery.jsp">Gallery</a></li>
                    <li class="nav-item dropdown">
                      <a
                        class="nav-link dropdown-toggle"
                        href="#"
                        id="dropdown02"
                        data-toggle="dropdown"
                        aria-haspopup="true"
                        aria-expanded="false"
                        >Destinations</a
                      >
                      <div class="dropdown-menu" aria-labelledby="dropdown02">
                        <a class="dropdown-item" href="destinations.jsp"
                          >Destinations</a
                        >
                        <a class="dropdown-item" href="destination-detail.jsp"
                          >Destination Detail</a
                        >
                      </div>
                    </li>
                    <li class="nav-item dropdown">
                      <a
                        class="nav-link dropdown-toggle"
                        href="#"
                        id="dropdown04"
                        data-toggle="dropdown"
                        aria-haspopup="true"
                        aria-expanded="false"
                        >Blog</a
                      >
                      <div class="dropdown-menu" aria-labelledby="dropdown04">
                        <a class="dropdown-item" href="blog.jsp">Blog</a>
                        <a class="dropdown-item" href="blog-single.jsp"
                          >Blog Singal</a
                        >
                      </div>
                    </li>
                    <li class="nav-item dropdown active">
                      <a
                        class="nav-link dropdown-toggle"
                        href="#"
                        id="dropdown05"
                        data-toggle="dropdown"
                        aria-haspopup="true"
                        aria-expanded="false"
                        >Pages</a
                      >
                      <div class="dropdown-menu" aria-labelledby="dropdown05">
                        <a class="dropdown-item" href="listing.jsp"
                          >Hotel Listing</a
                        >
                        <a class="dropdown-item" href="hotel-detail.jsp"
                          >Hotel Detail</a
                        >
                        <a class="dropdown-item" href="signin.jsp">Login</a>
                        <a class="dropdown-item" href="register.jsp"
                          >Register</a
                        >
                        <a class="dropdown-item" href="team.jsp">Team</a>
                        <a class="dropdown-item" href="testimonial.jsp"
                          >Testimonial</a
                        >
                        <a
                          class="dropdown-item"
                          href="traveler-information.jsp"
                          >Traveler Information</a
                        >
                        <a class="dropdown-item" href="ord_page.jsp"
                          >Payment Information</a
                        >
                        <a class="dropdown-item" href="faq.jsp">Faq</a>
                      </div>
                    </li>
                    <li>
                      <a class="nav-link" href="contact-us.jsp">Contact Us</a>
                    </li>
                  </ul>
                </div>
                <!-- top menu end -->
              </nav>
              <!-- header navigation end -->
            </div>
            <div class="col-lg-4 col-md-6 col-sm-8 col-10 text-right">
              <!-- header right link -->
              <div class="header-right-link">
                <ul>
                  <li>
                    <a href="signin.jsp"
                      ><i class="fas fa-chevron-right"></i> Sign in</a
                    >
                  </li>
                  <li>
                    <a href="register.jsp"
                      ><i class="fas fa-chevron-right"></i> Register</a
                    >
                  </li>
                  <li>
                    <a href="contact-us.jsp" class="header-request"
                      >Request a Quote</a
                    >
                  </li>
                </ul>
              </div>
              <!-- header right link end -->
            </div>
          </div>
        </div>
      </div>
      <!-- header upper end -->
      <!-- header lover -->
      <div class="header-lover">
        <div class="container">
          <div class="row align-items-center">
            <div class="col-lg-3 col-md-12">
              <!-- brand -->
              <div class="logo">
                <a class="navbar-brand p-0" href="index.jsp"
                  ><img src="images/logo.png" alt=""
                /></a>
              </div>
              <!-- brand end -->
            </div>
            <div class="col-lg-9 col-md-12">
              <!-- header call us -->
              <div class="header-call-us">
                <ul>
                  <li>
                    <div class="iocn-holder"><i class="far fa-clock"></i></div>
                    <div class="text-holder">
                      <h6>Working Hours</h6>
                      <p class="mb-0">Monday - Sunday: 9.00am to 6.00pm</p>
                    </div>
                  </li>
                  <li>
                    <div class="iocn-holder">
                      <i class="fas fa-phone-volume"></i>
                    </div>
                    <div class="text-holder">
                      <h6>Call Us</h6>
                      <p class="mb-0">
                        <a href="tel:123456789">+011 123 4567</a>
                      </p>
                    </div>
                  </li>
                  <li>
                    <div class="iocn-holder">
                      <i class="far fa-envelope"></i>
                    </div>
                    <div class="text-holder">
                      <h6>Mail Us</h6>
                      <p class="mb-0">
                        <a href="mailto:info@exampal.com">info@exampal.com</a>
                      </p>
                    </div>
                  </li>
                </ul>
              </div>
              <!-- header call us end -->
            </div>
          </div>
        </div>
      </div>
      <!-- header lover end -->
    </header>
    <!-- ================ Header end ================ -->

    <!-- ================ Inner banner ================ -->
    <div class="inner-banner inner-banner-bg pt-70 pb-40">
      <div class="container">
        <div class="row align-items-center">
          <div class="col-lg-8 col-md-8 mb-30">
            <!-- page-title -->
            <div class="page-title">
              <h1>Payment Information</h1>
            </div>
            <!-- page-title end -->
          </div>
          <div class="col-lg-4 col-md-4 mb-30">
            <!-- breadcrumb -->
            <ol class="breadcrumb mb-0">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Payment Information</li>
            </ol>
            <!-- breadcrumb end -->
          </div>
        </div>
      </div>
    </div>
    <!-- ================ Inner banner end ================ -->

    <!-- ================ Payment Information page ================ -->
    <div class="detail-page pt-70 pb-40">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-8 mb-30">
            <form class="form-style-1">
              <h4 class="mb-15">信用卡資訊</h4>
              <div class="card-type">
                <div class="row">
                  <div class="col-lg-6 mb-20">
                    <!-- <div
                      class="card-type-img border rounded p-20 text-center position-relative"
                    >
                      <input
                        class="form-check-input"
                        type="radio"
                        name="option2"
                        value="option2"
                      />
                      <img src="images/card-type-img-1.jpg" alt="" />
                    </div> -->
                  </div>
                  <div class="col-lg-6 mb-20">
                    <!-- <div
                      class="card-type-img border rounded p-20 text-center position-relative"
                    >
                      <input
                        class="form-check-input"
                        type="radio"
                        name="option2"
                        value="option2"
                      />
                      <img src="images/card-type-img-2.jpg" alt="" />
                    </div> -->
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-lg-6">
                  <div class="form-group">
                    <label
                      >Card Holder Name<span class="text-danger">*</span></label
                    >
                    <input type="text" class="form-control" />
                  </div>
                </div>
                <div class="col-lg-6">
                  <div class="form-group">
                    <label>Card Number<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" />
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-lg-4">
                  <div class="form-group">
                    <label
                      >Expiry Mounth<span class="text-danger">*</span></label
                    >
                    <input type="text" class="form-control" />
                  </div>
                </div>
                <div class="col-lg-4">
                  <div class="form-group">
                    <label>Expiry Year<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" />
                  </div>
                </div>
                <div class="col-lg-4">
                  <div class="form-group">
                    <label>CVC<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" />
                  </div>
                </div>
              </div>
              <div class="form-group form-check">
                <input
                  type="checkbox"
                  class="form-check-input"
                  id="exampleCheck1"
                />
                <label class="form-check-label font-size-14" for="exampleCheck1"
                  >我已閱讀並接受 <a href="">本網站付款條款</a></label
                >
              </div>
              <button type="submit" class="btn-style-1">確認付款</button>
            </form>
          </div>
          <div class="col-lg-4 col-md-4">
            <aside>
              <!-- filter widget -->
              <div class="filter-widget mb-20">
                <div
                  class="accordion filter-accordion"
                  id="filter-widget-accordion4-d"
                >
                  <div class="card">
                    <div class="card-header" id="headingOne4-d">
                      <a
                        class="btn btn-link w-100 text-left"
                        href=""
                        data-toggle="collapse"
                        data-target="#collapseOne4-m"
                        aria-expanded="true"
                        aria-controls="collapseOne4-m"
                      >
                        <!-- title widget -->
                        <div class="filter-title-widget">
                          <h3>
                            <!-- Hotel Details -->
                            訂單明細
                            <i class="fas fa-plus-square float-right"></i>
                            <i class="fas fa-minus-square float-right"></i>
                          </h3>
                        </div>
                        <!-- title widget end -->
                      </a>
                    </div>
                    <div
                      id="collapseOne4-m"
                      class="collapse show mt-10"
                      aria-labelledby="headingOne4-d"
                      data-parent="#filter-widget-accordion4-d"
                    >
                      <div class="card-body">
                        <ul class="list-inline select-all mb-10">
                          <li class="list-inline-item">
                            <!-- Hilton Miami Downtown -->
                          </li>
                        </ul>
                        <div class="table-responsive">
                          <table
                            class="table table-bordered bg-gray w-100 border-0"
                          >
                            <tr>
                              <!-- <td>Check In</td> -->
                              <td>入住時間</td>
                              <td>Nov 16,2022 (三)</td>
                            </tr>
                            <tr>
                              <!-- <td>Check Out</td> -->
                              <td>退房時間</td>
                              <td>Nov 17,2022 (四)</td>
                            </tr>
                            <!-- <tr>
                              <td>Room 1</td>
                              <td>1 Adult(s)</td>
                            </tr> -->
                            <tr>
                              <!-- <td>
                                <form class="form-style-1">
                                  <input
                                    type="text"
                                    class="form-control"
                                    placeholder="Coupon Code"
                                  />
                                </form>
                              </td> -->
                              <!-- <td>
                                <button type="submit" class="btn-style-1">
                                  Apply
                                </button>
                              </td> -->
                            </tr>
                          </table>
                        </div>
                        <div class="table-responsive">
                          <table
                            class="table table-bordered bg-gray mb-0 w-100 border-0"
                          >
                            <!-- <tr>
                              <td>Adult Price</td>
                              <td>$900</td>
                            </tr>
                            <tr>
                              <td>Children Price</td>
                              <td>$0</td>
                            </tr>
                            <tr>
                              <td>Infant Price</td>
                              <td>$0</td>
                            </tr>
                            <tr>
                              <td>Subtotal</td>
                              <td>$0</td>
                            </tr>
                            <tr>
                              <td>Tex</td>
                              <td>0%</td>
                            </tr> -->
                            <tr>
                              <th>房型種類</th>
                              <th>雙人房</th>
                            </tr>
                            <tr>
                              <th>訂房數</th>
                              <th>1間</th>
                            </tr>
                            <tr>
                              <!-- <th>Pay Amount</th> -->
                              <th>金額</th>
                              <th>$900</th>
                            </tr>
                          </table>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <!-- filter widget end -->
              <!-- help us -->
              <!-- <div class="help-us mb-30">
                <h3>How can we help you?</h3>
                <p>
                  Lorem ipsum dolor sit ametdf consectetur adipiscing elitdgsh
                  ametdf consectetur piscing.
                </p>
                <a class="view-detail-btn" href=""
                  ><i class="fas fa-phone-alt"></i> Contact Us</a
                >
              </div> -->
              <!-- help us end -->
            </aside>
          </div>
        </div>
      </div>
    </div>
    <!-- ================ Payment Information page end ================ -->

    <!-- ================ Footer area ================ -->
    <footer class="pt-50">
      <div class="footer-top">
        <div class="container">
          <div class="row">
            <div class="col-lg-3 col-md-3 col-sm-6 mb-30">
              <!-- title -->
              <div class="title mb-10">
                <h3>About Us</h3>
              </div>
              <!-- title end -->
              <!-- text -->
              <div class="text">
                <p>
                  Lorem ipsum dolor sit amet sectetur adipiscing elit amet
                  consectetur scing elit amet consectetur adipiscing elit sed et
                  eletum.
                </p>
                <p>
                  Lorem ipsum dolor sit amet sectetur adipiscing elit amet
                  consectetur scing elit amet.
                </p>
              </div>
              <!-- end text -->
              <!-- footer social -->
              <div class="footer-social">
                <a href=""><i class="fab fa-facebook-square"></i></a>
                <a href=""><i class="fab fa-twitter-square"></i></a>
                <a href=""><i class="fab fa-linkedin"></i></a>
                <a href=""><i class="fab fa-pinterest-square"></i></a>
                <a href=""><i class="fab fa-google-plus-square"></i></a>
              </div>
              <!-- footer social end -->
            </div>
            <div class="col-lg-3 col-md-3 col-sm-6 mb-30">
              <!-- title -->
              <div class="title mb-10">
                <h3>Navigation</h3>
              </div>
              <!-- title end -->
              <!-- footer link -->
              <ul class="footer-link">
                <li><i class="fas fa-caret-right"></i> <a href="#">Home</a></li>
                <li>
                  <i class="fas fa-caret-right"></i> <a href="#">About Us</a>
                </li>
                <li>
                  <i class="fas fa-caret-right"></i> <a href="#">Services</a>
                </li>
                <li>
                  <i class="fas fa-caret-right"></i> <a href="#">Projects</a>
                </li>
                <li><i class="fas fa-caret-right"></i> <a href="#">Blog</a></li>
                <li><i class="fas fa-caret-right"></i> <a href="#">Faq</a></li>
                <li>
                  <i class="fas fa-caret-right"></i> <a href="#">Contact</a>
                </li>
              </ul>
              <!-- footer link end -->
            </div>
            <div class="col-lg-3 col-md-3 col-sm-6 mb-30">
              <!-- title -->
              <div class="title mb-10">
                <h3>Recent posts</h3>
              </div>
              <!-- title end -->
              <!-- recent-posts -->
              <div class="footer-recent-post">
                <!-- footer recent post item -->
                <div class="footer-recent-post-item">
                  <a href="">
                    <p>
                      Lorem ipsum dolor sit amet sectetur adipiscing elit amet
                    </p>
                    <small
                      ><i class="far fa-calendar-alt pr-6"></i> 01 Oct
                      2020</small
                    ></a
                  >
                </div>
                <!-- footer recent post item end -->
                <!-- footer recent post item -->
                <div class="footer-recent-post-item">
                  <a href="">
                    <p>
                      Lorem ipsum dolor sit amet sectetur adipiscing elit amet
                    </p>
                    <small
                      ><i class="far fa-calendar-alt pr-6"></i> 01 Oct
                      2020</small
                    ></a
                  >
                </div>
                <!-- footer recent post item end -->
                <!-- footer recent post item -->
                <div class="footer-recent-post-item">
                  <a href="">
                    <p>
                      Lorem ipsum dolor sit amet sectetur adipiscing elit amet
                    </p>
                    <small
                      ><i class="far fa-calendar-alt pr-6"></i> 01 Oct
                      2020</small
                    ></a
                  >
                </div>
                <!-- footer recent post item end -->
              </div>
              <!-- recent-posts end -->
            </div>
            <div class="col-lg-3 col-md-3 col-sm-6 mb-30">
              <!-- title -->
              <div class="title mb-10">
                <h3>Newsletter</h3>
              </div>
              <!-- title end -->
              <!-- footer newsletter text -->
              <div class="footer-newsletter-text">
                <p>
                  Lorem ipsum dolor sit amet sectetur adipiscing elit amet
                  consectetur scing elit sed et eletum.
                </p>
              </div>
              <!-- footer newsletter text end -->
              <!-- footer newsletter form -->
              <div class="footer-newsletter-form">
                <form>
                  <input placeholder="Email Adress..." type="text" required />
                  <button type="submit">Subscribe</button>
                </form>
              </div>
              <!-- footer newsletter form end -->
            </div>
          </div>
        </div>
      </div>
      <!-- footer copyright -->
      <div class="copyright text-center mt-20">
        © <span class="current-year"></span> All Rights Reserved.
      </div>
      <!-- footer copyright end -->
    </footer>
    <!-- ================ Footer area end ================ -->

    <!-- ================ Top scroll ================ -->
    <a href="#" class="scroll-top">Top</a>
    <!-- ================ Top scroll end ================ -->

<!--     js files -->
    <script src="/HOOGLE/datetimepicker/js/jquery-3.5.1.min.js"></script>
    <script src="/HOOGLE/datetimepicker/js/bootstrap.bundle.min.js"></script>
<!--     counter js -->
    <script src="/HOOGLE/datetimepicker/js/jquery-1.10.2.min.js"></script>
    <script src="/HOOGLE/datetimepicker/js/waypoints.min.js"></script>
    <script src="/HOOGLE/datetimepicker/js/jquery.counterup.min.js"></script>
<!--     venobox js -->
    <script src="/HOOGLE/datetimepicker/js/venobox.min.js"></script>
<!--     owl carousel -->
    <script src="/HOOGLE/datetimepicker/js/owl.carousel.min.js"></script>
<!--     portfolio js -->
    <script src="/HOOGLE/datetimepicker/js/jquery.mixitup.min.js"></script>
<!--     datepicker js -->
    <script src="/HOOGLE/datetimepicker/js/datepicker.min.js"></script>
<!--     script js -->
    <script src="/HOOGLE/datetimepicker/js/custom.js"></script>
  </body>
</html>
