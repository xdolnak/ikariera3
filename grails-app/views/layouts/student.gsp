<!doctype html>
<html>
<head>

    <g:set var="entityName" value="iKariera.cz"/>

    <title><g:layoutTitle default="${message(code: 'page.main.title')}"/></title>


    <asset:stylesheet src="application.css"/>

    <asset:javascript src="main.js"/>
    <asset:javascript src="application.js"/>
    <asset:javascript src="studentEducation.js"/>

    <g:render template="/layouts/mainLayout/pageHead"/>
    <g:render template="/layouts/mainLayout/googleAnalytics"/>



    <g:render template="/layouts/mainLayout/pageHead"/>
    <g:render template="/layouts/mainLayout/googleAnalytics"/>

    <g:layoutHead/>


</head>

<body>

<div class="wrapper">

<g:render template="/layouts/sharedLayout/maintanceMode" />


<g:render template="/layouts/studentLayout/loggedTopMenu" />


<div class="menu-part">

    <g:render template="/layouts/studentLayout/mainMenu"/>

</div>


<g:render template="/layouts/studentLayout/flashMessages"/>



<div style="min-height: 400px">

    <g:layoutBody/>

</div>



<div class="footer">
    <g:render template="/layouts/mainLayout/footer"/>

</div>


</div>




%{-- sticky footer --}%
<g:render template="/layouts/sharedLayout/bottomStickyBar"/>





<g:render template="/layouts/mainLayout/dialogs"/>





<script>
    $(document).foundation();


</script>

</body>
</html>