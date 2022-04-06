<h1 style="font-family: 'Times New Roman'">USE CASE 6 : The top N populated countries in a region where N is provided by the user.</h1>
<h2 style="font-family: 'Times New Roman'"> CHARACTERISTIC INFORMATION</h2>
<h3 style="font-family: 'Times New Roman'; font-size: 20px">Goal in Context</h3>
<span style="font-family: 'Times New Roman'; font-size: 18px;"> As a report manager, we want to produce a report on the countries in a region by the users so that we can support the population of countries in a region.</span>

<h3 style="font-family: 'Times New Roman'; font-size: 20px">Scope</h3>
<span style="font-family: 'Times New Roman'; font-size: 18px;">An organisation.</span>

<h3 style="font-family: 'Times New Roman'; font-size: 20px">Level</h3>
<span style="font-family: 'Times New Roman'; font-size: 18px;">Primary task.</span>

<h3 style="font-family: 'Times New Roman'; font-size: 20px">Preconditions</h3>
<span style="font-family: 'Times New Roman'; font-size: 18px;">We know the role. Work Database contains the population data,but we require the user request to view the top population.</span>

<h3 style="font-family: 'Times New Roman'; font-size: 20px">Success End Condition</h3>
<span style="font-family: 'Times New Roman'; font-size: 18px;"> A report is available for report manager to provide the user requests for displaying the top populated of countries in a region.</span>

<h3 style="font-family: 'Times New Roman'; font-size: 20px">Failed End Condition</h3>
<span style="font-family: 'Times New Roman'; font-size: 18px;">No report is produced.</span>

<h3 style="font-family: 'Times New Roman'; font-size: 20px">Primary Actor</h3>
<span style="font-family: 'Times New Roman'; font-size: 18px;">Report Manager.</span>

<h3 style="font-family: 'Times New Roman'; font-size: 20px">Trigger</h3>
<span style="font-family: 'Times New Roman'; font-size: 18px;">A request for top populated information is sent to report manager.</span>

<h3 style="font-family: 'Times New Roman'; font-size: 20px">MAIN SUCCESS SCENARIO</h3>
<ol>
<li style="font-family: 'Times New Roman'; font-size: 18px;">The report manager requires the user requests of country information.</li>
<li style="font-family: 'Times New Roman'; font-size: 18px;">The system needs to extract the top N populated by the users .</li>
<li style="font-family: 'Times New Roman'; font-size: 18px;">The system provides a report for top N population information of countries in a region. </li> 
</ol>
<h2 style="font-family: 'Times New Roman'; font-size: 20px">EXTENSIONS</h2>
<dl style="font-family: 'Times New Roman'; font-size: 18px">
<dt>Role does not exist:</dt>
<dd>The system informs the top N population of countries in a region by the users requests.</dd>
</dl>
<h2 style="font-family: 'Times New Roman'; font-size: 20px">SUB-VARIATIONS</h2> 
<span style="font-family: 'Times New Roman';font-size: 18px;">None</span>
<h2 style="font-family: 'Times New Roman'">SCHEDULE</h2> 
<span style="font-family: 'Times New Roman'; font-size: 18px;"> DUE DATE: Release 3.0</span>
