<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="What Do We Know - Find out about and request open data sets near you"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">

    <g:layoutHead/>
    <r:require modules="register,wdwkstyle,bootstrap-popover"/>
    <g:javascript library="application"/>
    <r:layoutResources />

  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <g:link controller="home" action="index" class="navbar-brand">Open Local Information Directory</g:link>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <sec:ifLoggedIn>
              <sec:ifAnyGranted roles="ROLE_ADMIN">
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">Admin Menu</a>
                  <ul class="dropdown-menu">
                    <li><g:link controller="admin" action="approveOrgs">Approve Organisations</g:link></li>
                    <li><g:link controller="admin" action="approveAffiliations">Approve Affiliations</g:link></li>
                    <li><g:link controller="admin" action="loadVocabulary">Load Vocabulary</g:link></li>
                    <li><g:link controller="search" action="index" params="${[qbe:'g:refdataCategories']}">Refdata Categories</g:link></li>
                    <li><g:link controller="search" action="index" params="${[qbe:'g:resources']}">Resources</g:link></li>
                    <li><g:link controller="search" action="index" params="${[qbe:'g:orgs']}">Organisations</g:link></li>
                    <li><g:link controller="search" action="index" params="${[qbe:'g:locations']}">Addresses</g:link></li>
                    <li><g:link controller="create" action="index" params="${[tmpl:'tli.TliLocation']}">Create Address</g:link></li>
                    <li><g:link controller="collection" action="index">Resources</g:link></li>
                    <li><g:link controller="admin" action="loadOrgs">Bulk Load Organisations</g:link></li>
                    <li><g:link controller="admin" action="forceFTUpdate">Force Index Update</g:link></li>
                    <li><g:link controller="admin" action="forceEnrichment">Force Enrichment</g:link></li>
                  </ul>
                </li>
              </sec:ifAnyGranted>

              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">My Questions</a>
                <ul class="dropdown-menu">
                  <li><a>blah</a></li>
                </ul>
              </li>

              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">My DataSets</a>
                <ul class="dropdown-menu">
                  <li><a>blah</a></li>
                </ul>
              </li>

 
              <li><a href="#about">About</a></li>
              <li><a href="#contact">Contact</a></li>
            </sec:ifLoggedIn>
            <li>
                <g:link controller="ask" action="index">Ask for Data!</g:link>
            </li>
          </ul>


          <ul class="nav navbar-nav pull-right">
            <sec:ifLoggedIn>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">${request.user?.username} <b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li><g:link controller="api">Api</g:link></li>
                  <li><g:link controller="profile">Profile</g:link></li>
                  <li><g:link controller="logout">Logout</g:link></li>
                </ul>
              </li>
            </sec:ifLoggedIn>
            <sec:ifNotLoggedIn>
              <!--<li><p class="navbar-text">Not logged in</p></li>-->
              <li><g:link controller="login">Login</g:link></li>
              <li><g:link controller="register">Register</g:link></li>
            </sec:ifNotLoggedIn>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="main">
    <g:layoutBody/>
    </div>


    <g:if test="${grailsApplication.config.analytics?.code!=null}">
      <g:javascript>
        (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)})(window,document,'script','//www.google-analytics.com/analytics.js','ga');
        ga('create', '${grailsApplication.config.analytics.code}', '${grailsApplication.config.analytics.host}');
        ga('send', 'pageview');
      </g:javascript>
    </g:if>

    <r:layoutResources/>

    </body>
</html>
