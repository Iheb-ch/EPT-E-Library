<!DOCTYPE html>
<html lang="en-US" ng-app="myApp">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta charset="ISO-8859-15">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <%--    <link rel="profile" href="https://gmpg.org/xfn/11">--%>
    <%--    <link rel="pingback" href="https://wordpress.library-management.com/xmlrpc.php">--%>
    <link href="../resources/css/fonts.css" rel="stylesheet">
    <link href="../resources/css/ionicons.css" rel="stylesheet">
    <title>Issue Book</title>
    <link rel='dns-prefetch' href='//s.w.org' />
    <link rel='stylesheet' id='wp-block-library-css'  href='https://wordpress.library-management.com/wp-includes/css/dist/block-library/style.min.css?ver=5.2.2' type='text/css' media='all' />
    <link rel='stylesheet' id='font_awesome-css'  href='https://wordpress.library-management.com/wp-content/themes/library/css/font-awesome.min.css?ver=5.2.2' type='text/css' media='all' />
    <link rel='stylesheet' id='bootstrap-css'  href='https://wordpress.library-management.com/wp-content/themes/library/css/bootstrap.min.css?ver=5.2.2' type='text/css' media='all' />
    <link rel='stylesheet' id='slick-css'  href='https://wordpress.library-management.com/wp-content/themes/library/css/slick.css?ver=5.2.2' type='text/css' media='all' />
    <link rel='stylesheet' id='slick_theme-css'  href='https://wordpress.library-management.com/wp-content/themes/library/css/slick-theme.css?ver=5.2.2' type='text/css' media='all' />
    <link rel='stylesheet' id='button-css'  href='https://wordpress.library-management.com/wp-content/themes/library/css/button.css?ver=5.2.2' type='text/css' media='all' />
    <link rel='stylesheet' id='adminLTE-css'  href='https://wordpress.library-management.com/wp-content/themes/library/css/AdminLTE.min.css?ver=5.2.2' type='text/css' media='all' />
    <link rel='stylesheet' id='skin-css'  href='https://wordpress.library-management.com/wp-content/themes/library/css/_all-skins.min.css?ver=5.2.2' type='text/css' media='all' />
    <link rel='stylesheet' id='iziToastCss-css'  href='https://wordpress.library-management.com/wp-content/themes/library/css/iziToast.min.css?ver=5.2.2' type='text/css' media='all' />
    <link rel='stylesheet' id='tooltipcss-css'  href='https://wordpress.library-management.com/wp-content/themes/library/css/angular-tooltips.css?ver=5.2.2' type='text/css' media='all' />
    <link rel='stylesheet' id='datetimepickerCss-css'  href='https://wordpress.library-management.com/wp-content/themes/library/css/jquery.datetimepicker.min.css?ver=5.2.2' type='text/css' media='all' />
    <link rel='stylesheet' id='angular_bootstrap_toggle_css-css'  href='https://wordpress.library-management.com/wp-content/themes/library/css/angular-bootstrap-toggle.min.css?ver=5.2.2' type='text/css' media='all' />
    <link rel='stylesheet' id='datatable_css-css'  href='https://wordpress.library-management.com/wp-content/themes/library/css/dataTables.bootstrap.min.css?ver=5.2.2' type='text/css' media='all' />
    <link rel='stylesheet' id='mainstyle-css'  href='https://wordpress.library-management.com/wp-content/themes/library/style.css?ver=5.2.2' type='text/css' media='all' />
<%--    <script type="text/javascript" src="https://gc.kis.v2.scr.kaspersky-labs.com/FD126C42-EBFA-4E12-B309-BB3FDD723AC1/main.js?attr=yxJBeZrb38tC8sMWbY3y2Gcjz-ni21u-usdxmdt5BAn6fsR0DY0JYkFdYMtdGf43Ybl6LPvtGNMTZQoNb5M6bY9N85IynZ2s_Mn5dj0nDvY" charset="UTF-8"></script><script type='text/javascript' src='https://wordpress.library-management.com/wp-includes/js/jquery/jquery.js?ver=1.12.4-wp'></script>--%>
<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-includes/js/jquery/jquery-migrate.min.js?ver=1.4.1'></script>--%>
<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-content/themes/library/js/bootstrap.min.js?ver=5.2.2'></script>--%>
<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-content/themes/library/js/jquery-ui.min.js?ver=5.2.2'></script>--%>
<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-content/themes/library/js/slick.min.js?ver=5.2.2'></script>--%>
<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-content/themes/library/js/ripple-effect.js?ver=5.2.2'></script>--%>
<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-content/themes/library/js/jquery.validate.js?ver=5.2.2'></script>--%>
<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-content/themes/library/js/angular.min.js?ver=5.2.2'></script>--%>
<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-content/themes/library/js/angular-animate.js?ver=5.2.2'></script>--%>
<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-content/themes/library/js/jquery.numeric.min.js?ver=5.2.2'></script>--%>
<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-content/themes/library/js/iziToast.min.js?ver=5.2.2'></script>--%>
<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-content/themes/library/js/angular-tooltips.min.js?ver=5.2.2'></script>--%>
<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-content/themes/library/js/jquery.datetimepicker.full.js?ver=5.2.2'></script>--%>
<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-content/themes/library/js/jquery.datetimepicker.min.js?ver=5.2.2'></script>--%>
<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-content/themes/library/js/app.min.js?ver=5.2.2'></script>--%>
<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-content/themes/library/js/jquery.slides.min.js?ver=5.2.2'></script>--%>
<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-content/themes/library/js/webcam.min.js?ver=5.2.2'></script>--%>
<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-content/themes/library/js/ng-camera.js?ver=5.2.2'></script>--%>
<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-content/themes/library/js/canvasjs.min.js?ver=5.2.2'></script>--%>
<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-content/themes/library/js/angular-bootstrap-toggle.min.js?ver=5.2.2'></script>--%>
<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-content/themes/library/js/bootbox.min.js?ver=5.2.2'></script>--%>
<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-content/themes/library/js/jquery.blockUI.js?ver=5.2.2'></script>--%>
<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-content/themes/library/js/jquery.dataTables.min.js?ver=5.2.2'></script>--%>
<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-content/themes/library/js/dataTables.bootstrap.min.js?ver=5.2.2'></script>--%>
<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-content/themes/library/js/tinymce/tinymce.min.js?ver=5.2.2'></script>--%>

<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-content/themes/library/js/custom.js?ver=5.2.2'></script>--%>
<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-content/themes/library/js/ng-file-upload-shim.js?ver=5.2.2'></script>--%>
<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-content/themes/library/js/ng-file-upload.js?ver=5.2.2'></script>--%>
<%--    <script type='text/javascript' src='https://wordpress.library-management.com/wp-content/themes/library/js/custom_ang.js?ver=5.2.2'></script>--%>
    <link rel='https://api.w.org/' href='https://wordpress.library-management.com/wp-json/' />
    <link rel="EditURI" type="application/rsd+xml" title="RSD" href="https://wordpress.library-management.com/xmlrpc.php?rsd" />
    <link rel="wlwmanifest" type="application/wlwmanifest+xml" href="https://wordpress.library-management.com/wp-includes/wlwmanifest.xml" />
    <meta name="generator" content="WordPress 5.2.2" />
    <link rel="canonical" href="https://wordpress.library-management.com/issue-books/" />
    <link rel='shortlink' href='https://wordpress.library-management.com/?p=54' />
    <link rel="alternate" type="application/json+oembed" href="https://wordpress.library-management.com/wp-json/oembed/1.0/embed?url=https%3A%2F%2Fwordpress.library-management.com%2Fissue-books%2F" />
    <link rel="alternate" type="text/xml+oembed" href="https://wordpress.library-management.com/wp-json/oembed/1.0/embed?url=https%3A%2F%2Fwordpress.library-management.com%2Fissue-books%2F&#038;format=xml" />


</head>
<body>
<div class="col-sm-9">
    <form class="form-horizontal ng-valid ng-dirty ng-valid-parse" id="lib_issue_book_form" novalidate="novalidate" method="post">
        <div class="tab-content shadow">
            <div class="tab-pane active">
                <div class=" panel panel-custom">
                    <div class="panel-heading">
                        <div class="panel-title">
                            <strong>Issue Books</strong>
                        </div>
                    </div>
                    <div class="panel-body form-horizontal">
                        <input type="hidden" name="action" value="issue_book" autocomplete="off" wfd-invisible="true">

                        <div class="form-group mb0 col-sm-12">

                            <label>Book ID</label><input name="book_no" id="book_no" ng-model="book_no" ng-change="onBookNoChange()" placeholder="Type Book ID . Eg:4321603" class="form-control ng-pristine ng-untouched ng-valid ng-scope" type="text">

                        </div>

                        <div class="form-group mb0 col-sm-12">
                            <table class="table table-bordered ng-hide" ng-show="qty !=null" style="border: 1px solid lightgrey;" wfd-invisible="true">
                            </table>
                        </div>

                        <div class="form-group mb0 col-sm-12">
                            <label>Student Id</label>
                            <input name="student_id" id="user_id" ng-model="user_id" ng-change="user_idChange()" placeholder="Type Student ID. Eg : 1001" class="form-control ng-valid ng-touched ng-dirty ng-valid-parse ng-empty error" type="text" aria-required="true" aria-invalid="true"><label id="user_id-error" class="error" for="user_id">User ID is required.</label>
                        </div>



                        <div class="form-group mb0 col-sm-6">
                            <label>Date Issued</label>

                            <input name="book_date_borrowed" ng-model="book_date_borrowed" id="book_date_borrowed" class="form-control fix_radius ng-valid ng-empty ng-touched ng-dirty ng-valid-parse" type="text" placeholder="YYYY-MM-JJ">
                        </div>

                        <div class="form-group mb0 col-sm-6">
                            <label>By when to Return</label>

                            <input name="book_date_due" ng-model="book_date_due" id="book_date_due" class="form-control fix_radius ng-valid ng-empty ng-touched ng-dirty ng-valid-parse" type="text" placeholder="YYYY-MM-JJ">

                        </div>

                        <div class="form-group md0 col-sm-12" style="    padding-right: 0px;">

                                <button class="btn btn-primary btn-xl" id="submitButton" type="submit">Issue Book</button>
                        </div>

                    </div>
                </div>
            </div>



        </div></form>
</div>
</body>
</html>