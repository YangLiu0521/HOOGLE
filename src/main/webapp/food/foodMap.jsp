<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>美食地圖</title>
    <%@ include file="/header.jsp"%>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" />
    <style>
        .container {
            padding-top: 30px;
            padding-bottom: 30px;
        }

        #map {
            background: #CCC;
        }

        ul {
            padding-top: 16px;
        }

        .media img {
            max-width: 64px;
        }

        .media h5,
        p {
            font-size: 14px;
        }

        .mdeia p {
            margin-bottom: 6px;
        }

        .media h6 {
            font-size: 12px;
            color: #CCC;
        }

        .fixed-bottom {
            position: fixed;
            left: 16px;
            bottom: 0;
            max-width: 320px;
        }

        .category {
            position: relative;
            padding: 0 15px;
            margin-bottom: 30px;
        }

        .category .col-md-3 {
            padding: 0;
        }

        .category .category-item {
            position: relative;
            display: flex;
            flex-wrap: wrap;
            align-items: center;
            height: 100%;
            max-height: 400px;
            overflow: hidden;
            background: #ffffff;
        }

        .category .category-item.ch-400 {
            height: 400px;
        }

        .category .category-item.ch-250 {
            height: 250px;
        }

        .category .category-item.ch-150 {
            height: 150px;
        }

        .category .category-item img {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }

        .category .category-name {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            display: flex;
            align-items: center;
            background: rgba(250, 171, 81, 0.7);
            transition: all 0.3s;
            opacity: 0;
        }

        .category .category-name:hover {
            opacity: 1;
        }

        .category .category-name p {
            margin: 0 0 50px 0;
            padding: 15px;
            width: 100%;
            text-align: center;
            color: #ffffff;
            font-size: 16px;
            transition: all 0.3s;
        }

        .category .category-name:hover p {
            margin: 0;
        }
    </style>


</head>

<body>


    <div id="app" class="container">


        <div class="row">
            <div class="col google-map">
                <h3>請輸入地點，即可搜尋周邊美食：</h3>
                <div class="form-group">
                    <input type="text" class="form-control" ref="site" v-model="site">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col google-map">
                <h5>Google Map：</h5>
                <div id="map" class="embed-responsive embed-responsive-16by9"></div>
            </div>
        </div>

        <hr>
        <div class="category">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-3">
                        <div class="category-item ch-400">
                           <img src="<%=request.getContextPath()%>/images/foodn/f22.jpg" />
                            <a class="category-name" href="">
                            </a>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="category-item ch-250">
                           <img src="<%=request.getContextPath()%>/images/foodn/f005.jpg" />
                            <a class="category-name" href="">
                            </a>
                        </div>
                        <div class="category-item ch-150">
                            <img src="<%=request.getContextPath()%>/images/foodn/f006.jpg" />
                            <a class="category-name" href="">
                            </a>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="category-item ch-150">
                            <img src="<%=request.getContextPath()%>/images/foodn/f007.jpg" />
                            <a class="category-name" href="">
                            </a>
                        </div>
                        <div class="category-item ch-250">
                            <img src="<%=request.getContextPath()%>/images/foodn/f008.jpg" />
                            
                            
                            <a class="category-name" href="">
                               
                            </a>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="category-item ch-400">
                           <img src="<%=request.getContextPath()%>/images/foodn/f002.jpg" />
                            <a class="category-name" href="">
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>


<%@ include file="/footer.jsp"%>
        <script
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC8hT7LVKWFPXBM32y__t3z5EpAGg3_4Xw&libraries=places"></script>
        <script
            src="https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=25.047492,121.5165119&radius=500&types=restaurant&key=AIzaSyC8hT7LVKWFPXBM32y__t3z5EpAGg3_4Xw"></script>
        </script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.6.10/vue.min.js"></script>

        <!-- map -->
        <script>
            const googleMap = new Vue({
                el: '#app',
                data: {
                    map: null,
                    autocomplete: null,
                    site: '',
                    place: null
                },
                methods: {
                    // init google map
                    initMap() {

                        let location = {
                            lat: 25.047492,
                            lng: 121.516511
                        };

                        this.map = new google.maps.Map(document.getElementById('map'), {
                            center: location,
                            zoom: 16
                        });
                    },
                    siteAuto() {

                        let options = {
                            componentRestrictions: { country: 'tw' }
                        };
                        this.autocomplete = new google.maps.places.Autocomplete(this.$refs.site, options);
                        this.autocomplete.addListener('place_changed', () => {
                            this.place = this.autocomplete.getPlace();

                            if (this.place.geometry) {
                                let searchCenter = this.place.geometry.location;
                                this.map.panTo(searchCenter);


                                let marker = new google.maps.Marker({
                                    position: searchCenter,
                                    map: this.map
                                });

                                // info window
                                let infowindow = new google.maps.InfoWindow({
                                    content: this.place.formatted_address
                                });
                                infowindow.open(this.map, marker);

                            }
                        });
                    }
                },
                mounted() {
                    window.addEventListener('load', () => {

                        this.initMap();
                        this.siteAuto();

                    });
                }
            })
        </script>

</body>

</html>