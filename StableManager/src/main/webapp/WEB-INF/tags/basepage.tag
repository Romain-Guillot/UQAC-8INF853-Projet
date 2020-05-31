<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@attribute name="pageTitle" required="true"%>
<%@attribute name="pageHeader" fragment="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<%--        <link rel="stylesheet" href="http://127.0.0.1:8081/main.css" />--%>
        <link rel="stylesheet" href="/StableManager/assets/css/main.css" />

        <title>${pageTitle}</title>
    </head>
    <body>
        <header>
            <nav class="nav-wrapper">
                <div class="page-wrapper">
                    <a href="<s:url action='index' namespace="/"/>" class="brand-logo">
                        <svg height="512" viewBox="0 0 192 192" width="512" xmlns="http://www.w3.org/2000/svg"><g id="_01-horse" data-name="01-horse"><g id="glyph"><path d="m44.961 67.31c-28.191 49.522-43.917 111.528-44.722 114.75a8 8 0 0 0 7.761 9.94h88a8 8 0 0 0 8-8v-48.455l15.066 10.762 9.256-9.256z"/><path d="m167.078 98.3c-21.932-34.053-39.686-69.4-39.923-69.873a8 8 0 0 0 -7.155-4.427h-19.719l-13.625-20.437a8 8 0 0 0 -14.548 3.127c-1.014 6.11-3.894 22.391-5.835 29.4q-1.794 2.128-3.541 4.365l88.306 73.878z"/><path d="m190.247 131q-2.322-2.9-4.645-5.977l-40.138 40.138 1.886 1.347a8.017 8.017 0 0 0 2.12 1.079 31.547 31.547 0 0 0 23.891-2.429c8.918-4.9 15.109-14.054 18.4-27.22a8 8 0 0 0 -1.514-6.938z"/><path d="m178.343 98.343-26.824 26.824-100.038-83.694-10.267 12.272 98.947 82.781-17.818 17.817 11.314 11.314 56-56z"/></g></g></svg>
                        <span>StableManager</span>
                    </a>
                    <div class="right header-menu">
                        <a href="<s:url action='role/view/%{user.role.name}' namespace="/security"/>">${user.role.name}</a>
                        <a href="<s:url action='view/%{user.id}' namespace="/member"/>">My Account</a>
                        <a href="<s:url action='perform_logout' namespace="/auth"/>" class="waves-effect waves-light btn error-btn">Logout</a>
                    </div>
                </div>

            </nav>

            <div id="pageheader">
                <jsp:invoke fragment="pageHeader"/>
            </div>
        </header>


        <main>
            <div id="main" class="page-wrapper">
                <s:if test="hasActionErrors()">
                    <div class="errors">
                        <s:actionerror/>
                    </div>
                </s:if>
                <jsp:doBody/>
            </div>
        </main>
        <footer class="page-footer">
            <div class="page-wrapper">
                StableManager • v1
            </div>
        </footer>

    <script type="text/javascript" src="/StableManager/assets/css/materialize-src/js/bin/materialize.js"></script>
        <script>
        document.addEventListener('DOMContentLoaded', function() {
            var elems = document.querySelectorAll('select');
            var instances = M.FormSelect.init(elems, {});
        });

    </script>
    </body>
</html>