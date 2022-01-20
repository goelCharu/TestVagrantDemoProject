# Testvagrant Demo Project

<h2>testvagrant</h2>
This directory contains test automation suite demo project for APIs listed at https://openweathermap.org/current

<h2>How to run automation suite</h2>
<p>
<strong>Pre-requisite</strong>
<ul>
<li>Any IDE, used IntelliJ</li>
<li>Java 11</li>
</ul>

Once you install IntelliJ(or any other IDE of your choice), start it. On startup go to
<ul>
<li>File-> Open</li>
<li>Choose the directory at which you have cloned the code</li>
<li>Go to testvagrant directory</li>
<li>Click on pom.xml file and then OK button</li>
<li>Choose open as project on Pop up</li>
<li>Allow some time for IDE to fetch dependencies</li>
<li>Try building code to check if everything works fine from Menu->Build->BuildProject</li>
</ul>

</p>

<h2>How to run this suite ?</h2>
Right click on testng.xml file and choose "Run testng.xml and provide the browser name like firefox or chrome , default is chrome".

**NOTE**: create drivers directory in cloned code and place the .exe for chrome and firefox. Currey GIT does not allow to push exe file

<h2>What to expect once tests are executed ?</h2>
Three tests would run. One would fail and other two will pass.

<ul>
<li><strong>Failed Test case</strong> - verifyWeatherInformationForCityOutOfRange. Throws custom exception</li>
<li><strong>Passed Test case</strong> - verifyWeatherInformationForCity</li>
<li><strong>Passed Test case</strong> - verifyWeatherInformationForCityWithInRange</li>
</ul>

**DEBUG:**
