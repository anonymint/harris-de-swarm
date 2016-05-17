<html>
<head>
    <link rel="stylesheet" href="/uaa/webjars/bootstrap/3.2.0/css/bootstrap.min.css"/>
</head>
<body>
<div class="container well">
    <h2>Please Confirm</h2>

    <p>
        Do you authorize <strong>"${authorizationRequest.clientId}"</strong> at <strong>"${authorizationRequest.redirectUri}"</strong> to access your protected resources
        with scope <strong>${authorizationRequest.scope?join(", ")}</strong>.
    </p>
    <form id="confirmationForm" name="confirmationForm"
          action="../oauth/authorize" method="post">
        <input name="user_oauth_approval" value="true" type="hidden" />
        <input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="hidden" name="scope.${authorizationRequest.scope?join(", ")}" value="true"/>
        <button class="btn btn-primary" type="submit">Approve</button>
    </form>
    <form id="denyForm" name="confirmationForm"
          action="../oauth/authorize" method="post">
        <input name="user_oauth_approval" value="false" type="hidden" />
        <input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="hidden" name="scope.${authorizationRequest.scope?join(", ")}" value="false"/>
        <button class="btn btn-primary" type="submit">Deny</button>
    </form>
</div>
<script src="/uaa/webjars/jquery/2.1.1/jquery.min.js"	type="text/javascript"></script>
</body>
</html>