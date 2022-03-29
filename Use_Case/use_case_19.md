<h1 style="font-family: 'Times New Roman'">USE CASE 19: Produce a Report on the all the cities in a district organised by largest population to smallest.</h1>
<h2 style="font-family: 'Times New Roman'"> CHARACTERISTIC INFORMATION</h2>

<h3 style="font-family: 'Times New Roman'; font-size: 20px">Goal in Context</h3>
<span style="font-family: 'Times New Roman'; font-size: 18px;"> As a report manager, we want to produce a report on the all cities in a district so that we can support the population reporting of all cities in a district.</span>

<h3 style="font-family: 'Times New Roman'; font-size: 20px">Scope</h3>
<span style="font-family: 'Times New Roman'; font-size: 18px;">An organisation.</span>

<h3 style="font-family: 'Times New Roman'; font-size: 20px">Level</h3>
<span style="font-family: 'Times New Roman'; font-size: 18px;">Primary task.</span>

<h3 style="font-family: 'Times New Roman'; font-size: 20px">Preconditions</h3>
<span style="font-family: 'Times New Roman'; font-size: 18px;">We know the role. Work Database contains current population data of cities in a district.</span>

<h3 style="font-family: 'Times New Roman'; font-size: 20px">Success End Condition</h3>
<span style="font-family: 'Times New Roman'; font-size: 18px;"> A report is available for report manager to provide the population of cities in a district.</span>

<h3 style="font-family: 'Times New Roman'; font-size: 20px">Failed End Condition</h3>
<span style="font-family: 'Times New Roman'; font-size: 18px;">No report is produced.</span>

<h3 style="font-family: 'Times New Roman'; font-size: 20px">Primary Actor</h3>
<span style="font-family: 'Times New Roman'; font-size: 18px;">Report Manager</span>

<h3 style="font-family: 'Times New Roman'; font-size: 20px">Trigger</h3>
<span style="font-family: 'Times New Roman'; font-size: 18px;"> A request for population information is sent to report manager. </span>

<h3 style="font-family: 'Times New Roman'; font-size: 20px">MAIN SUCCESS SCENARIO</h3> 
<ol>
<li style="font-family: 'Times New Roman'; font-size: 18px;">The report manager asks the city information by the population.</li>  
<li style="font-family: 'Times New Roman'; font-size: 18px;">The system retrieves the data of a district from the database.</li>
<li style="font-family: 'Times New Roman'; font-size: 18px;">The system current population information by descending.</li> 
<li style="font-family: 'Times New Roman'; font-size: 18px;">The system provides a report for accessing the population in a district. </li> 
</ol>
<h2 style="font-family: 'Times New Roman'; font-size: 20px">EXTENSIONS</h2> 
<dl style="font-family: 'Times New Roman'; font-size: 18px">
<dt>Role does not exist:</dt>
<dd>The system informs the population of the cities in a district.</dd>
</dl>
<h2 style="font-family: 'Times New Roman'; font-size: 20px">SUB-VARIATIONS</h2> 
<span style="font-family: 'Times New Roman';font-size: 18px;">None</span>
<h2 style="font-family: 'Times New Roman'">SCHEDULE</h2>
<span style="font-family: 'Times New Roman'; font-size: 18px;"> DUE DATE: Release 2.0</span>