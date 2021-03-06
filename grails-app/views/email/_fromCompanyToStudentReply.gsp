<g:render template="/email/style/style"/>

<div style=" width: 800px;">

    Dobrý den, <br>

    pravě jste obdrželi zpravu od společnosti ${companyName} na jejíž nabídku jste odpověděli.
    <br>
    <br>


    <h3>Subjekt: </h3>
    <p>${messageSubject}</p>

    <h3>Zpráva: </h3>

    <p>
        <g:stripHtmlTags text="${messageText}"/>
    </p>

    <br/>
    <br/>

    <p>
        Tak se ozvěte. Můžete prostřednictvím emailu, nebo přímo kontaktovat:
        <br>
        ${companyEmail}

    </p>


    <br/>
    <g:render template="/email/contact"/>
</div>