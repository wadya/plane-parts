<h2>Plane Parts ver. 5</h2>
<br>
<h3>Write a Java console application that manages parts of a plane.</h3> 
<ol>
<li><p>A plane is built from parts like wings, wheels, engine etc. Configuration of parts structure of a plane should be kept in a file (choose the best format). Structure is represented by a tree, for instance (this is just an example, so name and quantities are read from file, depth of a structure is also dynamic so there can be many levels):</p>
<ul>
<li>Plane
<ul><li>Engine (with quantity 1)</li></ul>
</li>
<li>Bolt (with quantity 100)</li>
<li>Flywheel (with quantity 1)</li>
<li>Air Intake (with quantity 2)</li>
<ul><li>Wing (with quantity 2)</li>
<li>Cockpit (with quantity 1)</li></ul>
<li>Bolt (with Quantity 50)</li>
<li>... o...</li>
</li>
</ul>
<li>Each part is represented by a unique name. Structure contains information about quantities of part under specific parent part. From example above Bolt has quantity 100 under Engine and 50 under Cockpit.
</li>
<li><p>When an application starts it should read information about plane structure and be able to:</p>
<ul type="a"><li>a. Display sorted (by name) structure in a tabulated way. For example:</li>
<ul><li>Plane</li>
<li>Cockpit x1</li>
<li>Engine x1</li>
<li>Ait Intake x2</li>
<li>Bolt x100</li>
<li>Flywheel x1 Wing x2</li>
</ul>
</li>
<li><p>b. Display sorted (by quantity) structure in a tabulated way:</p>
<ul><li>Plane</li>
<li>Engine x1</li>
<li>Flywheel x1</li>
<li>Ait Intake x2</li>
<li>Bolt x100 Cockpit x1</li>
<li>Bolt x50 Wing x2</li>
</ul>
</li>
<li>c. Modify a structure by removing some parts. For example: Remove Engine from Plane.</li>
<li>d. Display under which parts given part is present. For example: Bolt is present under Cockpit and
Engine.</li>
<li>e. Add new parts specifying name, quantity and parent part</li>
<li>f. Modify quantity of a part</li>
<li>g. Manage parts (define new, change name of existing etc., remove). When part is removed it also</li>
should be removed from all structures.</li>
</li>
</ol>
