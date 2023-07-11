<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

        <!DOCTYPE html>
        <html>

        <head>

            <link rel="stylesheet" href="/css/bootstrap.min.css">
            <link rel="stylesheet" href="/css/bootstrap-select.css">
            <link href="/css/style.css" rel="stylesheet" type="text/css" media="all" />
            <link rel="stylesheet" href="/css/flexslider.css" type="text/css" media="screen" />
            <link rel="stylesheet" href="/css/font-awesome.min.css" />
            <!-- for-mobile-apps -->
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
            <meta name="keywords" content="Resale Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
        Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
            <script type="application/x-javascript">
                addEventListener("load", function() {
                    setTimeout(hideURLbar, 0);
                }, false);

                function hideURLbar() {
                    window.scrollTo(0, 1);
                }
            </script>
            <!-- //for-mobile-apps -->
            <!--fonts-->
            <link href='//fonts.googleapis.com/css?family=Ubuntu+Condensed' rel='stylesheet' type='text/css'>
            <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
            <!--//fonts-->
            <!-- js -->
            <script type="text/javascript" src="/js/jquery.min.js"></script>
            <!-- js -->
            <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
            <script src="/js/bootstrap.min.js"></script>
            <script src="/js/bootstrap-select.js"></script>
            <script>
                $(document).ready(function() {
                    var mySelect = $('#first-disabled2');

                    $('#special').on('click', function() {
                        mySelect.find('option:selected').prop('disabled', true);
                        mySelect.selectpicker('refresh');
                    });

                    $('#special2').on('click', function() {
                        mySelect.find('option:disabled').prop('disabled', false);
                        mySelect.selectpicker('refresh');
                    });

                    $('#basic2').selectpicker({
                        liveSearch: true,
                        maxOptions: 1
                    });
                });
            </script>
            <script type="text/javascript" src="/js/jquery.leanModal.min.js"></script>
            <link href="/css/jquery.uls.css" rel="stylesheet" />
            <link href="/css/jquery.uls.grid.css" rel="stylesheet" />
            <link href="/css/jquery.uls.lcd.css" rel="stylesheet" />
            <!-- Source -->
            <script src="/js/jquery.uls.data.js"></script>
            <script src="/js/jquery.uls.data.utils.js"></script>
            <script src="/js/jquery.uls.lcd.js"></script>
            <script src="/js/jquery.uls.languagefilter.js"></script>
            <script src="/js/jquery.uls.regionfilter.js"></script>
            <script src="/js/jquery.uls.core.js"></script>
            <script>
                $(document).ready(function() {
                    $('.uls-trigger').uls({
                        onSelect: function(language) {
                            var languageName = $.uls.data.getAutonym(language);
                            $('.uls-trigger').text(languageName);
                        },
                        quickList: ['en', 'hi', 'he', 'ml', 'ta', 'fr'] //FIXME
                    });
                });
            </script>
        </head>

        <body>
            <div class="header">
                <div class="container">
                    <div class="logo">
                        <a href="index.html"><span>Medi</span>co</a>
                    </div>
                    <div class="header-right">
                        <a class="account" href="/back/buypage/${id}">Back</a>

                        <!-- Large modal -->

                    </div>
                </div>
            </div>
            <br />
            <br/>
            <div class="container">
                <c:set var="amtTotal" value="${0}" />
                <c:if test="${not empty msg}">
                    ${msg}
                </c:if>
                <c:if test="${not empty emty}">
                    <div class="alert alert-success" role="alert">
                        ${emty}
                    </div>
                </c:if>



                <c:choose>
                    <c:when test="${medicines != null}">
                        <br/>
                        <h3>List of medicines</h3>
                        <br/>
                        <table cellpadding="20" cellspacing="20">
                            <thead>
                                <tr>
                                    <th>ID &nbsp&nbsp&nbsp</th>
                                    <th>Company Name &nbsp&nbsp&nbsp</th>
                                    <th>Medicine Name &nbsp&nbsp&nbsp</th>
                                    <th>order Date &nbsp&nbsp&nbsp</th>
                                    <th>Price in Rs. &nbsp&nbsp&nbsp</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="t" items="${medicines}">
                                    <tr>
                                        <td>${t.id}&nbsp&nbsp&nbsp</td>
                                        <td>${t.cname}&nbsp&nbsp&nbsp</td>
                                        <td>${t.mname}&nbsp&nbsp&nbsp</td>
                                        <td>${t.odate}&nbsp&nbsp&nbsp</td>
                                        <td>${t.price}&nbsp&nbsp&nbsp</td>
                                        <c:set var="amtTotal" value="${amtTotal + t.price}" />
                                        <td>
                                            <a class="button" href="<%=request.getContextPath()%>/remove/${t.id}/${id}">Remove</a> &nbsp;
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </c:when>
                    <c:otherwise>
                        No User found in the DB!
                    </c:otherwise>
                </c:choose>
                <a class="button" href="<%=request.getContextPath()%>/placeorder/${id}"> Pay Rs.${amtTotal} & checkout</a>
            </div>
            <!-- content-starts-here -->
            <!--footer section start-->
            <footer>
                <div class="footer-top">
                    <div class="container">
                        <div class="foo-grids">
                            <div class="col-md-3 footer-grid">
                                <h4 class="footer-head">Who We Are</h4>
                                <p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.</p>
                                <p>The point of using Lorem Ipsum is that it has a more-or-less normal letters, as opposed to using 'Content here.</p>
                            </div>
                            <div class="col-md-3 footer-grid">
                                <h4 class="footer-head">Help</h4>
                                <ul>
                                    <li><a href="howitworks.html">How it Works</a></li>
                                    <li><a href="sitemap.html">Sitemap</a></li>
                                    <li><a href="faq.html">Faq</a></li>
                                    <li><a href="feedback.html">Feedback</a></li>
                                    <li><a href="contact.html">Contact</a></li>
                                    <li><a href="typography.html">Shortcodes</a></li>
                                </ul>
                            </div>
                            <div class="col-md-3 footer-grid">
                                <h4 class="footer-head">Information</h4>
                                <ul>
                                    <li><a href="regions.html">Locations Map</a></li>
                                    <li><a href="terms.html">Terms of Use</a></li>
                                    <li><a href="popular-search.html">Popular searches</a></li>
                                    <li><a href="privacy.html">Privacy Policy</a></li>
                                </ul>
                            </div>
                            <div class="col-md-3 footer-grid">
                                <h4 class="footer-head">Contact Us</h4>
                                <span class="hq">Our headquarters</span>
                                <address>
                                        <ul class="location">
                                            <li><span class="glyphicon glyphicon-map-marker"></span></li>
                                            <li>CENTER FOR FINANCIAL ASSISTANCE TO DEPOSED NIGERIAN ROYALTY</li>
                                            <div class="clearfix"></div>
                                        </ul>	
                                        <ul class="location">
                                            <li><span class="glyphicon glyphicon-earphone"></span></li>
                                            <li>+0 561 111 235</li>
                                            <div class="clearfix"></div>
                                        </ul>	
                                        <ul class="location">
                                            <li><span class="glyphicon glyphicon-envelope"></span></li>
                                            <li><a href="mailto:info@example.com">mail@example.com</a></li>
                                            <div class="clearfix"></div>
                                        </ul>						
                                    </address>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
                <div class="footer-bottom text-center">
                    <div class="container">
                        <div class="footer-logo">
                            <a href="index.html"><span>Medi</span>Co</a>
                        </div>
                        <div class="footer-social-icons">
                            <ul>
                                <li><a class="facebook" href="#"><span>Facebook</span></a></li>
                                <li><a class="twitter" href="#"><span>Twitter</span></a></li>
                                <li><a class="flickr" href="#"><span>Flickr</span></a></li>
                                <li><a class="googleplus" href="#"><span>Google+</span></a></li>
                                <li><a class="dribbble" href="#"><span>Dribbble</span></a></li>
                            </ul>
                        </div>
                        <div class="copyrights">
                            <p> © 2016 Resale. All Rights Reserved | Design by <a href="http://w3layouts.com/"> W3layouts</a></p>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </footer>
            <!--footer section end-->
        </body>

        </html>