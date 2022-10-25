<?xml version="1.0" encoding="UTF-8"?>
<xmi:XMI xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:exercise="platform:/plugin/no.hal.learning.exercise.model/model/exercise.ecore" xmlns:jdt="platform:/plugin/no.hal.learning.exercise.jdt/model/jdt-exercise.ecore" xmlns:junit="platform:/plugin/no.hal.learning.exercise.junit/model/junit-exercise.ecore" xmlns:workbench="platform:/plugin/no.hal.learning.exercise.workbench/model/workbench-exercise.ecore">
  <exercise:Exercise>
    <parts xsi:type="exercise:ExercisePart" title="Java classes">
      <tasks xsi:type="exercise:Task">
        <q xsi:type="exercise:StringQuestion" question="Edit source code for Java classes."/>
        <a xsi:type="jdt:JdtSourceEditAnswer" resourcePath="/ovinger/src/*" className="*"/>
      </tasks>
      <tasks xsi:type="exercise:Task">
        <q xsi:type="exercise:StringQuestion" question="Launch Java classes."/>
        <a xsi:type="jdt:JdtLaunchAnswer" className="*"/>
      </tasks>
      <tasks xsi:type="exercise:Task">
        <q xsi:type="exercise:StringQuestion" question="Run JUnit tests."/>
        <a xsi:type="junit:JunitTestAnswer" testRunName="*"/>
      </tasks>
    </parts>
    <parts xsi:type="exercise:ExercisePart" title="Tool usage">
      <tasks xsi:type="exercise:Task">
        <q xsi:type="exercise:StringQuestion" question="Handle debug events."/>
        <a xsi:type="workbench:DebugEventAnswer" elementId="*" action="*.*"/>
      </tasks>
      <tasks xsi:type="exercise:Task">
        <q xsi:type="exercise:StringQuestion" question="Use debug commands"/>
        <a xsi:type="workbench:CommandExecutionAnswer" elementId="*" action="executeSuccess"/>
      </tasks>
      <tasks xsi:type="exercise:Task">
        <q xsi:type="exercise:StringQuestion" question="Use editors and views"/>
        <a xsi:type="workbench:PartTaskAnswer" elementId="*" action="*"/>
      </tasks>
    </parts>
  </exercise:Exercise>
  <exercise:ExerciseProposals exercise="/0">
    <proposals exercisePart="/0/@parts.0">
      <proposals xsi:type="jdt:JdtSourceEditProposal" question="/0/@parts.0/@tasks.0/@q" answer="/0/@parts.0/@tasks.0/@a">
        <attempts xsi:type="jdt:JdtSourceEditEvent" timestamp="1610977126317" resourcePath="/ovinger/src/main/java/module-info.java" sizeMeasure="13" warningCount="1" className=".module-info">
          <edit xsi:type="exercise:StringEdit" storedString="/**&#xA; * @author hal&#xA; *&#xA; */&#xA;open module ovinger {&#xA;&#x9;requires javafx.base;&#xA;&#x9;requires javafx.controls;&#xA;&#x9;requires javafx.fxml;&#xA;&#x9;requires javafx.graphics;&#xA;&#x9;requires junit;&#xA;&#x9;requires org.eclipse.xtext.xbase.lib;&#xA;&#x9;// requires no.hal.jex.jextest.lib;&#xA;}&#xA;"/>
          <markers xsi:type="jdt:JdtMarkerInfo" lineNumber="11" charStart="175" charEnd="202" severity="1" problemCategory="90" problemType="8390069"/>
        </attempts>
        <attempts xsi:type="jdt:JdtSourceEditEvent" timestamp="1610977361229" resourcePath="/ovinger/src/main/java/stateandbehavior/Account.java" sizeMeasure="5" className="stateandbehavior.Account">
          <edit xsi:type="exercise:ReplaceSubstringEdit" storedString="package stateandbehavior;&#xA;&#xA;public class Account {&#xA;" edit="/1/@proposals.0/@proposals.0/@attempts.0/@edit" end="-4"/>
        </attempts>
        <attempts xsi:type="jdt:JdtSourceEditEvent" timestamp="1611061066615" resourcePath="/ovinger/src/main/java/stateandbehavior/Digit.java" sizeMeasure="49" errorCount="1" warningCount="2" className="stateandbehavior.Digit">
          <edit xsi:type="exercise:ReplaceSubstringEdit" storedString="Digit {&#xA;&#x9;&#xA;&#x9;int base;&#xA;&#x9;int digit;&#xA;&#x9;&#xA;&#x9;public Digit(int numberSystem) {&#xA;&#x9;&#x9;this.base = numberSystem;&#xA;&#x9;}&#xA;&#x9;&#xA;&#x9;private int getValue() {&#xA;&#x9;&#x9;return this.digit;&#xA;&#x9;}&#xA;&#x9;&#xA;&#x9;private boolean increment() {&#xA;&#x9;&#x9;this.digit++;&#xA;&#x9;&#x9;if(digit == base) {&#xA;&#x9;&#x9;&#x9;digit = 0;&#xA;&#x9;&#x9;&#x9;return true;&#xA;&#x9;&#x9;}&#xA;&#x9;&#x9;else {&#xA;&#x9;&#x9;&#x9;return false;&#xA;&#x9;&#x9;}&#xA;&#x9;}&#xA;&#x9;&#xA;&#x9;private int getBase() {&#xA;&#x9;&#x9;return this.base;&#xA;&#x9;}&#xA;&#x9;&#xA;&#x9;@Override&#xA;&#x9;public String toString() {&#xA;&#x9;&#x9;if (this.digit &lt; 10) {&#xA;&#x9;&#x9;&#x9;return String.valueOf(digit);&#xA;&#x9;&#x9;} &#xA;&#x9;&#x9;else {&#xA;&#x9;&#x9;&#x9;return String.valueOf((char)((digit-10) + 'A' - 1));&#xA;&#x9;&#x9;}&#xA;&#x9;&#x9;&#xA;&#x9;}&#xA;&#x9;&#xA;&#x9;public static void main(String[] args) {&#xA;&#x9;&#x9;Digit newNumber = new Digit(8);&#xA;&#x9;&#x9;increment();&#xA;&#x9;&#x9;System.out.println(newNumber);&#xA;&#x9;&#x9;System.out.println(&quot;YO&quot;);&#xA;&#xA;&#x9;}" edit="/1/@proposals.0/@proposals.0/@attempts.1/@edit" start="40" end="-4"/>
          <markers xsi:type="jdt:JdtMarkerInfo" lineNumber="27" charStart="345" charEnd="354" severity="1" problemCategory="120" problemType="603979894"/>
        </attempts>
        <attempts xsi:type="jdt:JdtSourceEditEvent" timestamp="1611061074957" resourcePath="/ovinger/src/main/java/stateandbehavior/Digit.java" sizeMeasure="49" warningCount="2" className="stateandbehavior.Digit">
          <edit xsi:type="exercise:ReplaceSubstringEdit" storedString="newNumber." edit="/1/@proposals.0/@proposals.0/@attempts.2/@edit" start="639" end="-81"/>
          <markers xsi:type="jdt:JdtMarkerInfo" lineNumber="27" charStart="345" charEnd="354" severity="1" problemCategory="120" problemType="603979894"/>
        </attempts>
        <attempts xsi:type="jdt:JdtSourceEditEvent" timestamp="1611061077549" resourcePath="/ovinger/src/main/java/stateandbehavior/Digit.java" sizeMeasure="50" warningCount="2" className="stateandbehavior.Digit">
          <edit xsi:type="exercise:ReplaceSubstringEdit" storedString="&#xA;&#x9;&#x9;" edit="/1/@proposals.0/@proposals.0/@attempts.3/@edit" start="664" end="-66"/>
          <markers xsi:type="jdt:JdtMarkerInfo" lineNumber="27" charStart="345" charEnd="354" severity="1" problemCategory="120" problemType="603979894"/>
        </attempts>
        <attempts xsi:type="jdt:JdtSourceEditEvent" timestamp="1611061095343" resourcePath="/ovinger/src/main/java/stateandbehavior/Digit.java" sizeMeasure="51" warningCount="2" className="stateandbehavior.Digit">
          <edit xsi:type="exercise:ReplaceSubstringEdit" storedString="&#x9;this.digit = 0;&#xA;&#x9;" edit="/1/@proposals.0/@proposals.0/@attempts.4/@edit" start="138" end="-595"/>
          <markers xsi:type="jdt:JdtMarkerInfo" lineNumber="28" charStart="363" charEnd="372" severity="1" problemCategory="120" problemType="603979894"/>
        </attempts>
        <attempts xsi:type="jdt:JdtSourceEditEvent" timestamp="1611061141700" resourcePath="/ovinger/src/main/java/stateandbehavior/Digit.java" sizeMeasure="53" warningCount="1" className="stateandbehavior.Digit">
          <edit xsi:type="exercise:ReplaceSubstringEdit" storedString="&#x9;&#x9;System.out.println(newNumber.getBase());&#xA;&#xA;" edit="/1/@proposals.0/@proposals.0/@attempts.5/@edit" start="744" end="-7"/>
          <markers xsi:type="jdt:JdtMarkerInfo" lineNumber="13" charStart="173" charEnd="183" severity="1" problemCategory="120" problemType="603979894"/>
        </attempts>
        <attempts xsi:type="jdt:JdtSourceEditEvent" timestamp="1611061156245" resourcePath="/ovinger/src/main/java/stateandbehavior/Account.java" sizeMeasure="69" className="stateandbehavior.Account">
          <edit xsi:type="exercise:ReplaceSubstringEdit" storedString="Account {&#xA;&#x9;&#xA;&#x9;private int balance;&#xA;&#x9;private int interestRate;&#xA;&#x9;&#xA;&#x9;&#xA;&#x9;public Account() {&#xA;&#x9;&#x9;/*&#xA;&#x9;&#x9; * Double balance, Double interestRate&#xA;&#x9;&#x9; * this.balance = balance;&#xA;&#x9;&#x9;this.interestRate = interestRate;*/&#xA;&#x9;}&#xA;&#x9;&#xA;&#x9;public void deposit(int money) {&#xA;&#x9;&#x9;if (money > 0) {&#xA;&#x9;&#x9;&#x9;this.balance += money;&#xA;&#x9;&#x9;}&#xA;&#x9;}&#xA;&#x9;&#xA;&#x9;public void addInterest() {&#xA;&#x9;&#x9;int interest = this.balance * (this.interestRate)/100;&#xA;&#x9;&#x9;this.balance += interest;&#xA;&#x9;}&#xA;&#x9;&#xA;&#x9;public int getBalance() {&#xA;&#x9;&#x9;return this.balance;&#xA;&#x9;}&#xA;&#x9;&#xA;&#x9;public int getInterestRate() {&#xA;&#x9;&#x9;return this.interestRate;&#xA;&#x9;}&#xA;&#x9;&#xA;&#x9;public void setInterestRate(int newRate) {&#xA;&#x9;&#x9;this.interestRate = newRate;&#xA;&#x9;}&#xA;&#x9;&#xA;&#x9;@Override&#xA;&#x9;public String toString() {&#xA;&#x9;&#x9;return &quot;På kontoen er det nå &quot; + balance + &quot;kr og renten er &quot; + interestRate + &quot;%&quot;;&#xA;&#x9;}&#xA;&#x9;&#xA;&#x9;public static void main(String[] args) {&#xA;&#x9;&#x9;&#xA;&#x9;&#x9;Account account1 = new Account();&#xA;&#x9;&#x9;&#xA;&#x9;&#x9;account1.deposit(100);&#xA;&#x9;&#x9;account1.setInterestRate(3);&#xA;&#x9;&#x9;&#xA;&#x9;&#x9;account1.addInterest();&#xA;&#x9;&#x9;&#xA;&#x9;&#x9;&#xA;&#x9;&#x9;System.out.println(account1.getBalance());&#xA;&#x9;&#x9;System.out.println(account1.getInterestRate());&#xA;&#x9;&#x9;&#xA;&#x9;&#x9;account1.setInterestRate(4);&#xA;&#x9;&#x9;account1.deposit(100);&#xA;&#x9;&#x9;&#x9;&#x9;&#xA;&#x9;&#x9;&#xA;&#x9;&#x9;System.out.println(account1.getBalance());&#xA;&#x9;&#x9;System.out.println(account1.getInterestRate());&#xA;&#x9;&#x9;&#xA;&#x9;&#x9;System.out.println(account1);&#xA;&#x9;&#x9;&#xA;&#x9;&#x9;&#xA;&#x9;}&#xA;&#x9;" edit="/1/@proposals.0/@proposals.0/@attempts.6/@edit" start="40" end="-4"/>
        </attempts>
      </proposals>
      <proposals xsi:type="jdt:JdtLaunchProposal" question="/0/@parts.0/@tasks.1/@q" answer="/0/@parts.0/@tasks.1/@a">
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610291277860" mode="run" className="setupcheck.GuiWorks">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>setupcheck.GuiWorks</launchAttrValues>
          <launchAttrValues>ovinger</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610541812287" mode="run" className="eksempe.HelloWorld">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>eksempe.HelloWorld</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>5
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610541849744" mode="run" className="eksempe.HelloWorld">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>eksempe.HelloWorld</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>true
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610541864828" mode="run" className="eksempe.HelloWorld">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>eksempe.HelloWorld</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>5
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610620866372" mode="run" className="setupcheck.SimpleClass">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>setupcheck.SimpleClass</launchAttrValues>
          <launchAttrValues>ovinger</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>The program runs
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610973622638" mode="run" className="eksempe.Dog">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>eksempe.Dog</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>Woof
70
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610973719471" mode="run" className="eksempe.Dog">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>eksempe.Dog</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>Woof
70
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610973721847" mode="run" className="eksempe.Dog">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>eksempe.Dog</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>Woof
70
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610974133022" mode="run" className="eksempe.Dog">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>eksempe.Dog</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>Woof
70
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610974142353" mode="run" className="eksempe.Dog">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>eksempe.Dog</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>Woof
70
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610974277679" mode="run" className="eksempe.Dog">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>eksempe.Dog</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>Woof
70
eksempe.Dog@12843fce
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610974288409" mode="run" className="eksempe.Dog">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>eksempe.Dog</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>Woof
70
null
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610974300723" mode="run" className="eksempe.Dog">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>eksempe.Dog</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>Woof
70
Puddel
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610974309102" mode="run" className="eksempe.Dog">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>eksempe.Dog</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>Woof
70
0
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610974319115" mode="run" className="eksempe.Dog">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>eksempe.Dog</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>Woof
70
7
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610974348605" mode="run" className="eksempe.Dog">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>eksempe.Dog</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>Woof
70
Exception in thread &quot;main&quot; java.lang.Error: Unresolved compilation problem: 
	The method getDogYears() in the type Dog is not applicable for the arguments (int)

	at minegenkode/eksempe.Dog.&lt;init>(Dog.java:21)
	at minegenkode/eksempe.Dog.main(Dog.java:36)
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610974392163" mode="run" className="eksempe.Dog">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>eksempe.Dog</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>Woof
70
49
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610980136274" mode="run" className="ofVanskelig.Book">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>ofVanskelig.Book</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>Exception in thread &quot;main&quot; java.lang.Error: Unresolved compilation problem: 
	The method setNumPages(int) is undefined for the type Book

	at minegenkode/ofVanskelig.Book.main(Book.java:36)
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610980148943" mode="run" className="ofVanskelig.Book">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>ofVanskelig.Book</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>The book &quot;Big Java&quot; has 100 pages.
The book &quot;Introduction to Algorithms&quot; has 718 pages.
ofVanskelig.Book@12843fce
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610980352924" mode="run" className="ofVanskelig.Book">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>ofVanskelig.Book</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>The book &quot;Big Java&quot; has 100 pages.
The book &quot;Introduction to Algorithms&quot; has 718 pages.

</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610980437280" mode="run" className="ofVanskelig.Book">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>ofVanskelig.Book</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>The book &quot;Big Java&quot; has 100 pages.
The book &quot;Introduction to Algorithms&quot; has 718 pages.
Boken Introduction to Algorithms er på 718 sider
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610981982521" mode="run" className="ofVanskelig.Car">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>ofVanskelig.Car</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>Exception in thread &quot;main&quot; java.lang.Error: Unresolved compilation problems: 
	The constructor Car(String, String, String, int, double, double) is undefined
	The method driveDistance(double) is undefined for the type Car
	The method accelerate(int) is undefined for the type Car
	The method driveTime(double) is undefined for the type Car
	The method brake(int) is undefined for the type Car

	at minegenkode/ofVanskelig.Car.main(Car.java:98)
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610982075214" mode="run" className="ofVanskelig.Car">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>ofVanskelig.Car</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>Exception in thread &quot;main&quot; java.lang.Error: Unresolved compilation problem: 
	The constructor Car(String, String, String, int, double, double) is undefined

	at minegenkode/ofVanskelig.Car.main(Car.java:98)
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610982192665" mode="run" className="ofVanskelig.Car">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>ofVanskelig.Car</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>Exception in thread &quot;main&quot; java.lang.Error: Unresolved compilation problem: 

	at minegenkode/ofVanskelig.Car.main(Car.java:95)
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610982314990" mode="run" className="ofVanskelig.Car">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>ofVanskelig.Car</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>Exception in thread &quot;main&quot; java.lang.Error: Unresolved compilation problem: 

	at minegenkode/ofVanskelig.Car.main(Car.java:83)
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610982429345" mode="run" className="ofVanskelig.Car">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>ofVanskelig.Car</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>Exception in thread &quot;main&quot; java.lang.Error: Unresolved compilation problem: 

	at minegenkode/ofVanskelig.Car.main(Car.java:83)
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610982468232" mode="run" className="ofVanskelig.Car">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>ofVanskelig.Car</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>Exception in thread &quot;main&quot; java.lang.Error: Unresolved compilation problem: 

	at minegenkode/ofVanskelig.Car.main(Car.java:83)
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610982506778" mode="run" className="ofVanskelig.Car">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>ofVanskelig.Car</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>ofVanskelig.Car@12843fce
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610982524072" mode="run" className="ofVanskelig.Car">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>ofVanskelig.Car</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>Ford
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610982531134" mode="run" className="ofVanskelig.Car">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>ofVanskelig.Car</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>S-MAX
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610982539071" mode="run" className="ofVanskelig.Car">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>ofVanskelig.Car</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>AQ12345
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1610982560682" mode="run" className="ofVanskelig.Car">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>ofVanskelig.Car</launchAttrValues>
          <launchAttrValues>minegenkode</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>Exception in thread &quot;main&quot; java.lang.Error: Unresolved compilation problem: 
	The method driveDistance(double) is undefined for the type Car

	at minegenkode/ofVanskelig.Car.main(Car.java:89)
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1611061038223" mode="run" className="stateandbehavior.Digit">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>stateandbehavior.Digit</launchAttrValues>
          <launchAttrValues>ovinger</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>0
YO
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1611061081190" mode="run" className="stateandbehavior.Digit">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>stateandbehavior.Digit</launchAttrValues>
          <launchAttrValues>ovinger</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>1
YO
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1611061102205" mode="run" className="stateandbehavior.Digit">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>stateandbehavior.Digit</launchAttrValues>
          <launchAttrValues>ovinger</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>1
YO
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1611061146038" mode="run" className="stateandbehavior.Digit">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>stateandbehavior.Digit</launchAttrValues>
          <launchAttrValues>ovinger</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>1
YO
8
</consoleOutput>
        </attempts>
        <attempts xsi:type="jdt:JdtLaunchEvent" timestamp="1611061159032" mode="run" className="stateandbehavior.Account">
          <launchAttrNames>org.eclipse.jdt.launching.CLASSPATH_PROVIDER</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MAIN_TYPE</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.MODULE_NAME</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.PROJECT_ATTR</launchAttrNames>
          <launchAttrNames>org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER</launchAttrNames>
          <launchAttrValues>org.eclipse.m2e.launchconfig.classpathProvider</launchAttrValues>
          <launchAttrValues>stateandbehavior.Account</launchAttrValues>
          <launchAttrValues>ovinger</launchAttrValues>
          <launchAttrValues>org.eclipse.m2e.launchconfig.sourcepathProvider</launchAttrValues>
          <consoleOutput>103
3
203
4
På kontoen er det nå 203kr og renten er 4%
</consoleOutput>
        </attempts>
      </proposals>
      <proposals xsi:type="junit:JunitTestProposal" question="/0/@parts.0/@tasks.2/@q" answer="/0/@parts.0/@tasks.2/@a"/>
    </proposals>
    <proposals exercisePart="/0/@parts.1">
      <proposals xsi:type="workbench:DebugEventProposal" question="/0/@parts.1/@tasks.0/@q" answer="/0/@parts.1/@tasks.0/@a"/>
      <proposals xsi:type="workbench:CommandExecutionProposal" question="/0/@parts.1/@tasks.1/@q" answer="/0/@parts.1/@tasks.1/@a">
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610288492358" elementId="no.hal.learning.exercise.ui.commands.OpenExerciseView" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610288686007" elementId="org.eclipse.ui.cocoa.arrangeWindowsInFront" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610288808039" elementId="org.eclipse.ui.window.preferences" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610288858621" elementId="org.eclipse.ui.newWizard" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610288869039" elementId="org.eclipse.fx.ide.ui.openwithsceneb" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610291086074" elementId="org.eclipse.ui.editors.lineNumberToggle" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610291159597" elementId="org.eclipse.ui.window.preferences" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610291207805" elementId="org.eclipse.ui.window.preferences" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610291277852" elementId="org.eclipse.jdt.debug.ui.localJavaShortcut.run" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610291287754" elementId="org.eclipse.ui.file.exit" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610445166712" elementId="org.eclipse.ui.file.exit" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610524710362" elementId="org.eclipse.ui.window.preferences" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610528562928" elementId="org.eclipse.ui.file.exit" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610541332858" elementId="org.eclipse.ui.file.properties" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610541478302" elementId="org.eclipse.jdt.ui.edit.text.java.open.type.hierarchy" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610541624278" elementId="org.eclipse.ui.edit.text.goto.lineEnd" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610541628370" elementId="org.eclipse.ui.edit.text.zoomIn" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610541674655" elementId="org.eclipse.ui.edit.text.goto.lineEnd" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610541681413" elementId="AUTOGEN:::org.eclipse.jdt.internal.ui.CompilationUnitEditor.ruler.actions/org.eclipse.jdt.internal.ui.javaeditor.JavaSelectRulerAction" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610541736447" elementId="org.eclipse.ui.edit.text.goto.lineStart" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610541737929" elementId="org.eclipse.ui.edit.text.goto.lineStart" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610541738137" elementId="org.eclipse.ui.edit.text.goto.lineStart" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610541738705" elementId="org.eclipse.ui.edit.text.goto.lineEnd" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610541739421" elementId="org.eclipse.ui.edit.text.goto.lineStart" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610541741024" elementId="org.eclipse.ui.edit.text.goto.lineEnd" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610541776322" elementId="org.eclipse.ui.edit.text.goto.lineEnd" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610541778209" elementId="org.eclipse.ui.edit.text.goto.lineEnd" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610541783475" elementId="org.eclipse.ui.window.preferences" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610541806602" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610541812281" elementId="org.eclipse.jdt.debug.ui.localJavaShortcut.run" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610541841238" elementId="org.eclipse.jdt.ui.edit.text.java.add.javadoc.comment" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610541844228" elementId="org.eclipse.ui.edit.undo" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610541849743" elementId="org.eclipse.jdt.debug.ui.localJavaShortcut.run" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610541861850" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610541864828" elementId="org.eclipse.jdt.debug.ui.localJavaShortcut.run" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610542000994" elementId="org.eclipse.ui.window.preferences" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610620628669" elementId="org.eclipse.ui.views.showView" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610620669381" elementId="org.eclipse.ui.views.showView" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610620866351" elementId="org.eclipse.jdt.debug.ui.localJavaShortcut.run" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610620983729" elementId="org.eclipse.egit.ui.team.Pull" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610621291121" elementId="org.eclipse.egit.ui.team.Pull" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610621369939" elementId="org.eclipse.ui.window.showKeyAssist" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610621446922" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610621452890" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610621457106" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610621458661" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610621459255" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610621460677" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610621464372" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610621465299" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610621465988" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610621466908" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610621467658" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610621468989" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610621469980" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610621471207" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610621479954" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610621484643" elementId="org.eclipse.ui.edit.text.goto.lineEnd" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610627050905" elementId="org.eclipse.ui.file.exit" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610973131450" elementId="org.eclipse.ui.edit.text.goto.lineStart" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610973132913" elementId="org.eclipse.ui.edit.text.goto.lineEnd" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610973411500" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610973419305" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610973433546" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610973562267" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610973619059" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610973622633" elementId="org.eclipse.jdt.debug.ui.localJavaShortcut.run" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610973683512" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610973699229" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610973719464" elementId="org.eclipse.debug.ui.commands.RunLast" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610973721843" elementId="org.eclipse.debug.ui.commands.RunLast" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610973943397" elementId="org.eclipse.ui.edit.text.goto.wordPrevious" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610973943898" elementId="org.eclipse.ui.edit.text.goto.wordPrevious" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610973944641" elementId="org.eclipse.ui.edit.text.goto.wordPrevious" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610973950304" elementId="org.eclipse.ui.edit.text.goto.lineEnd" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610974054430" elementId="org.eclipse.ui.edit.copy" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610974056956" elementId="org.eclipse.ui.edit.paste" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610974072676" elementId="org.eclipse.ui.edit.paste" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610974102604" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610974133020" elementId="org.eclipse.jdt.debug.ui.localJavaShortcut.run" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610974142346" elementId="org.eclipse.jdt.debug.ui.localJavaShortcut.run" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610974225899" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610974261491" elementId="org.eclipse.ui.edit.copy" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610974264446" elementId="org.eclipse.ui.edit.paste" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610974273637" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610974277677" elementId="org.eclipse.debug.ui.commands.RunLast" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610974287353" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610974288407" elementId="org.eclipse.debug.ui.commands.RunLast" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610974299497" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610974300721" elementId="org.eclipse.debug.ui.commands.RunLast" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610974307995" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610974309101" elementId="org.eclipse.debug.ui.commands.RunLast" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610974315457" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610974315534" elementId="org.eclipse.ui.edit.selectAll" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610974319113" elementId="org.eclipse.debug.ui.commands.RunLast" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610974346309" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610974348604" elementId="org.eclipse.debug.ui.commands.RunLast" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610974365695" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610974383762" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610974390569" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610974392158" elementId="org.eclipse.debug.ui.commands.RunLast" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610976166373" elementId="org.eclipse.egit.ui.team.Pull" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610976271744" elementId="org.eclipse.ui.file.refresh" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610976294930" elementId="org.eclipse.m2e.core.ui.command.updateProject" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610976472517" elementId="org.eclipse.ui.window.preferences" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610976875761" elementId="org.eclipse.egit.ui.team.Pull" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610976902315" elementId="org.eclipse.egit.ui.team.Pull" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610976945535" elementId="org.eclipse.egit.ui.team.Pull" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610977069055" elementId="org.eclipse.egit.ui.team.Pull" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610977126103" elementId="org.eclipse.egit.ui.team.ReplaceWithHead" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610977138559" elementId="org.eclipse.egit.ui.team.Pull" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610977514480" elementId="org.eclipse.ui.edit.copy" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610977540370" elementId="org.eclipse.ui.edit.copy" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610977544320" elementId="org.eclipse.ui.edit.paste" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610977555372" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610979561172" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610979571862" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610979585454" elementId="org.eclipse.ui.edit.text.goto.wordNext" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610979585748" elementId="org.eclipse.ui.edit.text.goto.wordNext" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610979585991" elementId="org.eclipse.ui.edit.text.goto.wordNext" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610979643072" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610979708204" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610979733809" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610979738148" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610979894302" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610979898397" elementId="org.eclipse.ui.edit.text.zoomOut" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610979899945" elementId="org.eclipse.ui.edit.text.zoomIn" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610979941924" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610980032440" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610980047052" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610980057613" elementId="org.eclipse.ui.edit.delete" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610980057806" elementId="org.eclipse.ui.edit.delete" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610980057985" elementId="org.eclipse.ui.edit.delete" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610980058463" elementId="org.eclipse.ui.edit.delete" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610980070777" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610980104852" elementId="org.eclipse.ui.edit.delete" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610980105002" elementId="org.eclipse.ui.edit.delete" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610980105177" elementId="org.eclipse.ui.edit.delete" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610980105383" elementId="org.eclipse.ui.edit.delete" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610980105988" elementId="org.eclipse.ui.edit.delete" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610980125158" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610980134438" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610980146983" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610980272269" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610980344845" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610980434403" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610981560994" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610981565427" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610981566752" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610981567484" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610981569268" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610981590052" elementId="org.eclipse.ui.edit.copy" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610981595484" elementId="org.eclipse.ui.edit.paste" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610981599521" elementId="org.eclipse.ui.edit.undo" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610981604265" elementId="org.eclipse.ui.edit.copy" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610981606407" elementId="org.eclipse.ui.edit.paste" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610981641832" elementId="org.eclipse.ui.edit.copy" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610981643184" elementId="org.eclipse.ui.edit.paste" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610981643650" elementId="org.eclipse.ui.edit.paste" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610981644074" elementId="org.eclipse.ui.edit.paste" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610981644531" elementId="org.eclipse.ui.edit.paste" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610981645134" elementId="org.eclipse.ui.edit.paste" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610981645897" elementId="org.eclipse.ui.edit.paste" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610981721238" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610981728814" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610981801530" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610981817910" elementId="org.eclipse.ui.edit.text.contentAssist.proposals" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610981896119" elementId="org.eclipse.jdt.ui.edit.text.java.create.getter.setter" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610981980540" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610982050037" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610982191046" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610982270884" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610982313742" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610982388334" elementId="org.eclipse.ui.edit.text.zoomOut" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610982427645" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610982468231" elementId="org.eclipse.jdt.debug.ui.localJavaShortcut.run" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610982498845" elementId="AUTOGEN:::org.eclipse.jdt.internal.ui.CompilationUnitEditor.ruler.actions/org.eclipse.jdt.internal.ui.javaeditor.JavaSelectRulerAction" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610982503345" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610982522448" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610982529818" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610982537338" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610982543364" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610982551161" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610982560681" elementId="org.eclipse.debug.ui.commands.RunLast" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610982598681" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1610982601564" elementId="org.eclipse.ui.file.exit" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1611061038219" elementId="org.eclipse.jdt.debug.ui.localJavaShortcut.run" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1611061066751" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1611061075050" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1611061077592" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1611061081183" elementId="org.eclipse.jdt.debug.ui.localJavaShortcut.run" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1611061095366" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1611061102196" elementId="org.eclipse.jdt.debug.ui.localJavaShortcut.run" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1611061124390" elementId="org.eclipse.ui.edit.copy" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1611061130938" elementId="org.eclipse.ui.edit.paste" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1611061141748" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1611061146031" elementId="org.eclipse.jdt.debug.ui.localJavaShortcut.run" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1611061156288" elementId="org.eclipse.ui.file.save" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1611061159024" elementId="org.eclipse.jdt.debug.ui.localJavaShortcut.run" action="executeSuccess"/>
        <attempts xsi:type="workbench:WorkbenchTaskEvent" timestamp="1611061168514" elementId="org.eclipse.ui.file.exit" action="executeSuccess"/>
      </proposals>
      <proposals xsi:type="workbench:PartTaskProposal" question="/0/@parts.1/@tasks.2/@q" answer="/0/@parts.1/@tasks.2/@a">
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288492165" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288492185" elementId="no.hal.learning.exercise.views.ExerciseView" action="opened"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288492207" elementId="no.hal.learning.exercise.views.ExerciseView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288492238" elementId="no.hal.learning.exercise.views.ExerciseView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288500540" elementId="org.eclipse.jdt.junit.ResultView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288500552" elementId="no.hal.learning.exercise.views.ExerciseView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288500618" elementId="org.eclipse.jdt.junit.ResultView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288500663" elementId="org.eclipse.jdt.junit.ResultView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288500686" elementId="no.hal.learning.exercise.views.ExerciseView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288510855" elementId="no.hal.learning.exercise.views.ExerciseView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288510888" elementId="no.hal.learning.exercise.views.ExerciseView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288511679" elementId="no.hal.learning.exercise.views.ExerciseView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288511699" elementId="no.hal.learning.exercise.views.ExerciseView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288511712" elementId="no.hal.learning.exercise.views.ExerciseView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288513847" elementId="org.eclipse.jdt.junit.ResultView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288513858" elementId="no.hal.learning.exercise.views.ExerciseView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288513894" elementId="org.eclipse.jdt.junit.ResultView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288513928" elementId="org.eclipse.jdt.junit.ResultView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288513971" elementId="no.hal.learning.exercise.views.ExerciseView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288517512" elementId="no.hal.learning.exercise.views.ExerciseView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288517539" elementId="no.hal.learning.exercise.views.ExerciseView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288517548" elementId="no.hal.learning.exercise.views.ExerciseView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288530255" elementId="no.hal.learning.exercise.views.ExerciseView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288530340" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/test/java/setupcheck/SimpleClassTest.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288833039" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/test/java/setupcheck/SimpleClassTest.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288833086" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288858231" elementId="org.eclipse.fx.ide.fxml.editors.FXMLEditor" action="opened" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/MyGui.fxml"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288858326" elementId="org.eclipse.fx.ide.fxml.editors.FXMLEditor" action="broughtToTop" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/MyGui.fxml"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288858436" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288858483" elementId="org.eclipse.fx.ide.fxml.editors.FXMLEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/MyGui.fxml"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288865678" elementId="org.eclipse.fx.ide.fxml.editors.FXMLEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/MyGui.fxml"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610288865700" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291081564" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291081738" elementId="org.eclipse.fx.ide.fxml.editors.FXMLEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/MyGui.fxml"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291169546" elementId="org.eclipse.fx.ide.fxml.editors.FXMLEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/MyGui.fxml"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291169606" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291171236" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/SimpleClass.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291171264" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291171315" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/SimpleClass.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291213648" elementId="org.eclipse.ui.views.ContentOutline" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291213715" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291213748" elementId="org.eclipse.ui.views.TaskList" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291213761" elementId="net.sourceforge.plantuml.eclipse.views.PlantUmlView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291213772" elementId="org.eclipse.ui.console.ConsoleView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291213789" elementId="org.eclipse.jdt.junit.ResultView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291213801" elementId="no.hal.learning.exercise.views.ExerciseView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291213848" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/GuiWorks.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291213894" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/ovinger/src/test/java/setupcheck/SimpleClassTest.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291213923" elementId="org.eclipse.fx.ide.fxml.editors.FXMLEditor" action="closed" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/MyGui.fxml"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291213946" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/SimpleClass.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291213947" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/SimpleClass.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291233349" elementId="no.hal.learning.exercise.views.ExerciseView" action="opened"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291233936" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/SimpleClass.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291264829" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/SimpleClass.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291264926" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291271657" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="opened" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/GuiWorks.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291271683" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/GuiWorks.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291271760" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291271865" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/GuiWorks.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291285950" elementId="org.eclipse.ui.console.ConsoleView" action="opened"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291286857" elementId="org.eclipse.ui.views.ContentOutline" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291287069" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291287108" elementId="org.eclipse.ui.views.TaskList" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291287126" elementId="org.eclipse.ui.console.ConsoleView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291287159" elementId="no.hal.learning.exercise.views.ExerciseView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291287209" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/SimpleClass.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291287279" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/GuiWorks.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610291287280" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/GuiWorks.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610444719607" elementId="no.hal.learning.exercise.views.ExerciseView" action="opened"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610444720208" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/GuiWorks.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610445165708" elementId="org.eclipse.ui.views.ContentOutline" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610445165801" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610445165825" elementId="org.eclipse.ui.views.TaskList" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610445165845" elementId="no.hal.learning.exercise.views.ExerciseView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610445165925" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/GuiWorks.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610445165931" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/GuiWorks.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610522848551" elementId="no.hal.learning.exercise.views.ExerciseView" action="opened"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610522849260" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/GuiWorks.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610524712693" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/GuiWorks.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610524712822" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610524733828" elementId="org.eclipse.jdt.ui.ModuleInfoEditor" action="opened" inputUri="platform:/resource/minegenkode/src/main/java/module-info.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610524733914" elementId="org.eclipse.jdt.ui.ModuleInfoEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/module-info.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610524734013" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610524734086" elementId="org.eclipse.jdt.ui.ModuleInfoEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/module-info.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610524742597" elementId="org.eclipse.jdt.ui.ModuleInfoEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/module-info.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610524742702" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610524757422" elementId="org.eclipse.jdt.ui.ClassFileEditor" action="opened" inputUri="file:/var/folders/sh/v2jqcc_108112_sbp6tjc43m0000gn/T/AppleProvider.class7890582370382882997.class"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610524757567" elementId="org.eclipse.jdt.ui.ClassFileEditor" action="broughtToTop" inputUri="file:/var/folders/sh/v2jqcc_108112_sbp6tjc43m0000gn/T/AppleProvider.class7890582370382882997.class"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610524757794" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610524757958" elementId="org.eclipse.jdt.ui.ClassFileEditor" action="activated" inputUri="file:/var/folders/sh/v2jqcc_108112_sbp6tjc43m0000gn/T/AppleProvider.class7890582370382882997.class"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610524769313" elementId="org.eclipse.jdt.ui.ClassFileEditor" action="deactivated" inputUri="file:/var/folders/sh/v2jqcc_108112_sbp6tjc43m0000gn/T/AppleProvider.class7890582370382882997.class"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610524769356" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610528561560" elementId="org.eclipse.ui.views.TaskList" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610528561685" elementId="no.hal.learning.exercise.views.ExerciseView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610528561817" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/GuiWorks.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610528561978" elementId="org.eclipse.jdt.ui.ModuleInfoEditor" action="closed" inputUri="platform:/resource/minegenkode/src/main/java/module-info.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610528562041" elementId="org.eclipse.jdt.ui.ClassFileEditor" action="closed" inputUri="file:/var/folders/sh/v2jqcc_108112_sbp6tjc43m0000gn/T/AppleProvider.class7890582370382882997.class"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610528562083" elementId="org.eclipse.ui.views.ContentOutline" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610528562112" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610528562114" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541186297" elementId="no.hal.learning.exercise.views.ExerciseView" action="opened"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541186563" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541309301" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="opened" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541309348" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541309457" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541309490" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541311817" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541311858" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541342988" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541343031" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541457482" elementId="org.eclipse.jdt.ui.ClassFileEditor" action="closed" inputUri="file:/var/folders/sh/v2jqcc_108112_sbp6tjc43m0000gn/T/AppleProvider.class11755697742020335499.class"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541458977" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541459034" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541478121" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541478227" elementId="org.eclipse.jdt.ui.TypeHierarchy" action="opened"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541478237" elementId="org.eclipse.jdt.ui.TypeHierarchy" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541478271" elementId="org.eclipse.jdt.ui.TypeHierarchy" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541481534" elementId="no.hal.learning.exercise.views.ExerciseView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541481586" elementId="org.eclipse.jdt.ui.TypeHierarchy" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541481655" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541481690" elementId="org.eclipse.jdt.ui.TypeHierarchy" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541483156" elementId="org.eclipse.jdt.junit.ResultView" action="opened"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541483184" elementId="org.eclipse.jdt.junit.ResultView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541483196" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541483235" elementId="org.eclipse.jdt.junit.ResultView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541485249" elementId="org.eclipse.ui.console.ConsoleView" action="opened"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541485265" elementId="org.eclipse.ui.console.ConsoleView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541485278" elementId="org.eclipse.jdt.junit.ResultView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541485297" elementId="org.eclipse.ui.console.ConsoleView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541486357" elementId="net.sourceforge.plantuml.eclipse.views.PlantUmlView" action="opened"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541486382" elementId="net.sourceforge.plantuml.eclipse.views.PlantUmlView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541486391" elementId="org.eclipse.ui.console.ConsoleView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541486401" elementId="net.sourceforge.plantuml.eclipse.views.PlantUmlView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541487176" elementId="org.eclipse.jdt.junit.ResultView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541487183" elementId="net.sourceforge.plantuml.eclipse.views.PlantUmlView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541487198" elementId="org.eclipse.jdt.junit.ResultView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541496283" elementId="org.eclipse.jdt.junit.ResultView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541496330" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541506283" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541506342" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541565229" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="opened" inputUri="platform:/resource/ovinger/src/test/java/setupcheck/SimpleClassTest.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541565274" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/ovinger/src/test/java/setupcheck/SimpleClassTest.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541565409" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541565487" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/test/java/setupcheck/SimpleClassTest.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541567814" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541567861" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/test/java/setupcheck/SimpleClassTest.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541567906" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541568035" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541568060" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/test/java/setupcheck/SimpleClassTest.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541570875" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/test/java/setupcheck/SimpleClassTest.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541570900" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541570975" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/ovinger/src/test/java/setupcheck/SimpleClassTest.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541572273" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="opened" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/GuiWorks.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541572285" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/GuiWorks.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541572328" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541572341" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/GuiWorks.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541574878" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541574915" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/GuiWorks.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541574935" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541575002" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541575025" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/GuiWorks.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541577449" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/GuiWorks.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541577461" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541581914" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541581992" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/GuiWorks.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541582312" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/GuiWorks.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541582466" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541582627" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/GuiWorks.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541794681" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541794721" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541799284" elementId="org.eclipse.ui.console.ConsoleView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541799301" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541799351" elementId="org.eclipse.ui.console.ConsoleView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541800786" elementId="org.eclipse.ui.console.ConsoleView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610541800858" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610542010090" elementId="org.eclipse.ui.views.ContentOutline" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610542010131" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610542010164" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610542010165" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610542010218" elementId="org.eclipse.ui.views.TaskList" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610542010232" elementId="net.sourceforge.plantuml.eclipse.views.PlantUmlView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610542010238" elementId="org.eclipse.jdt.junit.ResultView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610542010245" elementId="no.hal.learning.exercise.views.ExerciseView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610542010282" elementId="org.eclipse.ui.console.ConsoleView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620615344" elementId="no.hal.learning.exercise.views.ExerciseView" action="opened"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620615369" elementId="no.hal.learning.exercise.views.ExerciseView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620615382" elementId="org.eclipse.egit.ui.RepositoriesView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620615427" elementId="no.hal.learning.exercise.views.ExerciseView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620616095" elementId="org.eclipse.jdt.junit.ResultView" action="opened"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620616128" elementId="org.eclipse.jdt.junit.ResultView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620616137" elementId="no.hal.learning.exercise.views.ExerciseView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620616164" elementId="org.eclipse.jdt.junit.ResultView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620616475" elementId="org.eclipse.ui.console.ConsoleView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620616482" elementId="org.eclipse.jdt.junit.ResultView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620616512" elementId="org.eclipse.ui.console.ConsoleView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620617467" elementId="net.sourceforge.plantuml.eclipse.views.PlantUmlView" action="opened"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620617502" elementId="net.sourceforge.plantuml.eclipse.views.PlantUmlView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620617509" elementId="org.eclipse.ui.console.ConsoleView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620617525" elementId="net.sourceforge.plantuml.eclipse.views.PlantUmlView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620619069" elementId="org.eclipse.egit.ui.RepositoriesView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620619085" elementId="net.sourceforge.plantuml.eclipse.views.PlantUmlView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620619119" elementId="org.eclipse.egit.ui.RepositoriesView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620628380" elementId="org.eclipse.egit.ui.RepositoriesView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620628567" elementId="org.eclipse.tm.terminal.view.ui.TerminalsView" action="opened"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620628620" elementId="org.eclipse.tm.terminal.view.ui.TerminalsView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620628657" elementId="org.eclipse.tm.terminal.view.ui.TerminalsView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620631594" elementId="org.eclipse.tm.terminal.view.ui.TerminalsView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620631637" elementId="org.eclipse.tm.terminal.view.ui.TerminalsView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620632048" elementId="org.eclipse.tm.terminal.view.ui.TerminalsView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620632062" elementId="org.eclipse.tm.terminal.view.ui.TerminalsView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620633204" elementId="org.eclipse.ui.views.TaskList" action="opened"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620633279" elementId="org.eclipse.ui.views.TaskList" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620633301" elementId="org.eclipse.tm.terminal.view.ui.TerminalsView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620633343" elementId="org.eclipse.ui.views.TaskList" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620633369" elementId="org.eclipse.tm.terminal.view.ui.TerminalsView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620633387" elementId="org.eclipse.ui.views.TaskList" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620633435" elementId="org.eclipse.tm.terminal.view.ui.TerminalsView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620640933" elementId="org.eclipse.tm.terminal.view.ui.TerminalsView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620641039" elementId="org.eclipse.fx.ide.fxml.editors.FXMLEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/MyGui.fxml"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620641503" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/SimpleClass.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620641540" elementId="org.eclipse.fx.ide.fxml.editors.FXMLEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/MyGui.fxml"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620641590" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/SimpleClass.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620642087" elementId="org.eclipse.fx.ide.fxml.editors.FXMLEditor" action="broughtToTop" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/MyGui.fxml"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620642107" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/SimpleClass.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620642150" elementId="org.eclipse.fx.ide.fxml.editors.FXMLEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/MyGui.fxml"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620643784" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/SimpleClass.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620643814" elementId="org.eclipse.fx.ide.fxml.editors.FXMLEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/MyGui.fxml"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620643867" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/SimpleClass.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620643997" elementId="org.eclipse.fx.ide.fxml.editors.FXMLEditor" action="closed" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/MyGui.fxml"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620644937" elementId="org.eclipse.egit.ui.RepositoriesView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620644952" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/SimpleClass.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620645010" elementId="org.eclipse.egit.ui.RepositoriesView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620645999" elementId="org.eclipse.tm.terminal.view.ui.TerminalsView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620646013" elementId="org.eclipse.egit.ui.RepositoriesView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620646035" elementId="org.eclipse.tm.terminal.view.ui.TerminalsView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620669185" elementId="org.eclipse.tm.terminal.view.ui.TerminalsView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620669280" elementId="org.eclipse.ui.views.ProblemView" action="opened"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620669324" elementId="org.eclipse.ui.views.ProblemView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620669370" elementId="org.eclipse.ui.views.ProblemView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620670980" elementId="org.eclipse.tm.terminal.view.ui.TerminalsView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620670992" elementId="org.eclipse.ui.views.ProblemView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620671012" elementId="org.eclipse.tm.terminal.view.ui.TerminalsView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620671571" elementId="org.eclipse.egit.ui.RepositoriesView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620671585" elementId="org.eclipse.tm.terminal.view.ui.TerminalsView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620671622" elementId="org.eclipse.egit.ui.RepositoriesView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620672183" elementId="no.hal.learning.exercise.views.ExerciseView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620672197" elementId="org.eclipse.egit.ui.RepositoriesView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620672227" elementId="no.hal.learning.exercise.views.ExerciseView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620673463" elementId="org.eclipse.egit.ui.RepositoriesView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620673478" elementId="no.hal.learning.exercise.views.ExerciseView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620673513" elementId="org.eclipse.egit.ui.RepositoriesView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620787882" elementId="org.eclipse.egit.ui.RepositoriesView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620787961" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620848754" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620848860" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/SimpleClass.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620868119" elementId="org.eclipse.ui.console.ConsoleView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620899108" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/SimpleClass.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620899180" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620915594" elementId="org.eclipse.mylyn.tasks.ui.views.tasks" action="opened"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620915642" elementId="org.eclipse.mylyn.tasks.ui.views.tasks" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620915653" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620915695" elementId="org.eclipse.mylyn.tasks.ui.views.tasks" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620917930" elementId="org.eclipse.ui.views.ContentOutline" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620917964" elementId="org.eclipse.mylyn.tasks.ui.views.tasks" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620918018" elementId="org.eclipse.ui.views.ContentOutline" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620920433" elementId="org.eclipse.ui.views.ContentOutline" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610620920466" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621009173" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="opened" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621009203" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621009250" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621009301" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621013925" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621014024" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621257109" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/SimpleClass.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621257148" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621257223" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/SimpleClass.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621260871" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/SimpleClass.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621260921" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621278763" elementId="org.eclipse.jdt.ui.ModuleInfoEditor" action="opened" inputUri="platform:/resource/foreksempel/src/main/java/module-info.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621278783" elementId="org.eclipse.jdt.ui.ModuleInfoEditor" action="broughtToTop" inputUri="platform:/resource/foreksempel/src/main/java/module-info.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621278825" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621278887" elementId="org.eclipse.jdt.ui.ModuleInfoEditor" action="activated" inputUri="platform:/resource/foreksempel/src/main/java/module-info.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621280615" elementId="org.eclipse.jdt.ui.ModuleInfoEditor" action="deactivated" inputUri="platform:/resource/foreksempel/src/main/java/module-info.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621280652" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621312553" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621312606" elementId="org.eclipse.jdt.ui.ModuleInfoEditor" action="activated" inputUri="platform:/resource/foreksempel/src/main/java/module-info.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621316345" elementId="org.eclipse.jdt.ui.ModuleInfoEditor" action="deactivated" inputUri="platform:/resource/foreksempel/src/main/java/module-info.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621316370" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621333396" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621333535" elementId="org.eclipse.jdt.ui.ModuleInfoEditor" action="activated" inputUri="platform:/resource/foreksempel/src/main/java/module-info.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621334791" elementId="org.eclipse.jdt.ui.ModuleInfoEditor" action="deactivated" inputUri="platform:/resource/foreksempel/src/main/java/module-info.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621334820" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621374859" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621374868" elementId="org.eclipse.ui.console.ConsoleView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621427413" elementId="org.eclipse.ui.console.ConsoleView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621427439" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621429261" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621429286" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610621429335" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610627048313" elementId="org.eclipse.mylyn.tasks.ui.views.tasks" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610627048413" elementId="org.eclipse.ui.views.ContentOutline" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610627048506" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610627048538" elementId="org.eclipse.ui.views.TaskList" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610627048562" elementId="net.sourceforge.plantuml.eclipse.views.PlantUmlView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610627048584" elementId="org.eclipse.jdt.junit.ResultView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610627048597" elementId="no.hal.learning.exercise.views.ExerciseView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610627048798" elementId="org.eclipse.egit.ui.RepositoriesView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610627048867" elementId="org.eclipse.tm.terminal.view.ui.TerminalsView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610627048930" elementId="org.eclipse.ui.views.ProblemView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610627048948" elementId="org.eclipse.ui.console.ConsoleView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610627049076" elementId="org.eclipse.mylyn.wikitext.ui.editor.markupEditor" action="closed" inputUri="platform:/resource/ovinger/oppgavetekster/README.md"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610627049293" elementId="org.eclipse.jdt.ui.ModuleInfoEditor" action="closed" inputUri="platform:/resource/ovinger/src/main/java/module-info.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610627049317" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/GuiWorks.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610627049359" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/SimpleClass.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610627049383" elementId="org.eclipse.jdt.ui.ModuleInfoEditor" action="closed" inputUri="platform:/resource/foreksempel/src/main/java/module-info.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610627049414" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610627049415" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/HelloWorld.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610972912609" elementId="no.hal.learning.exercise.views.ExerciseView" action="opened"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610972912636" elementId="no.hal.learning.exercise.views.ExerciseView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610972912644" elementId="org.eclipse.jdt.junit.ResultView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610972912689" elementId="no.hal.learning.exercise.views.ExerciseView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610972914308" elementId="org.eclipse.jdt.junit.ResultView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610972914335" elementId="no.hal.learning.exercise.views.ExerciseView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610972914367" elementId="org.eclipse.jdt.junit.ResultView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610972929416" elementId="org.eclipse.jdt.junit.ResultView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610972929441" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610972929804" elementId="no.hal.learning.exercise.presentation.ExerciseEditorID" action="opened" inputUri="platform:/resource/ovinger/src/test/java/setupcheck/simpleclass.ex"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610972929839" elementId="no.hal.learning.exercise.presentation.ExerciseEditorID" action="broughtToTop" inputUri="platform:/resource/ovinger/src/test/java/setupcheck/simpleclass.ex"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610972929845" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610972929901" elementId="no.hal.learning.exercise.presentation.ExerciseEditorID" action="activated" inputUri="platform:/resource/ovinger/src/test/java/setupcheck/simpleclass.ex"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610972931847" elementId="no.hal.learning.exercise.presentation.ExerciseEditorID" action="deactivated" inputUri="platform:/resource/ovinger/src/test/java/setupcheck/simpleclass.ex"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610972931933" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610972932961" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610972932986" elementId="no.hal.learning.exercise.presentation.ExerciseEditorID" action="activated" inputUri="platform:/resource/ovinger/src/test/java/setupcheck/simpleclass.ex"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610972937908" elementId="no.hal.learning.exercise.presentation.ExerciseEditorID" action="deactivated" inputUri="platform:/resource/ovinger/src/test/java/setupcheck/simpleclass.ex"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610972937927" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610973053077" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="opened" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610973053114" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610973053176" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610973053235" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610973428629" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610973428759" elementId="org.eclipse.search.ui.views.SearchView" action="opened"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610973428785" elementId="org.eclipse.search.ui.views.SearchView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610973428846" elementId="org.eclipse.search.ui.views.SearchView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610973429310" elementId="org.eclipse.search.ui.views.SearchView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610973429353" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610973623392" elementId="org.eclipse.ui.console.ConsoleView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610973750488" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="opened" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/DownCounter.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610973750526" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/DownCounter.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610973750631" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610973750682" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/DownCounter.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610973752242" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610973752277" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/DownCounter.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610973752304" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610974048789" elementId="org.eclipse.ui.views.ProblemView" action="opened"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610975841628" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610975841705" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976177567" elementId="org.eclipse.egit.ui.commitEditor" action="opened"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976177680" elementId="org.eclipse.egit.ui.commitEditor" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976177717" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976177805" elementId="org.eclipse.egit.ui.commitEditor" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976195568" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976195598" elementId="org.eclipse.egit.ui.commitEditor" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976195639" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976195683" elementId="org.eclipse.egit.ui.commitEditor" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976199768" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/RandomAverage.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976199792" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976199839" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/RandomAverage.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976200597" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976200640" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/RandomAverage.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976200662" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976200694" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/RandomAverage.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976202209" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Random100.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976203078" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/GuiWorks.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976203106" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976203126" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/GuiWorks.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976203967" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976203998" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/GuiWorks.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976204020" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976204039" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/ovinger/src/main/java/setupcheck/GuiWorks.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976204840" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/ovinger/src/test/java/setupcheck/SimpleClassTest.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976204872" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976204890" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/test/java/setupcheck/SimpleClassTest.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976205723" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976205766" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/test/java/setupcheck/SimpleClassTest.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976205784" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976205801" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/ovinger/src/test/java/setupcheck/SimpleClassTest.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976206737" elementId="no.hal.learning.exercise.presentation.ExerciseEditorID" action="broughtToTop" inputUri="platform:/resource/ovinger/src/test/java/setupcheck/simpleclass.ex"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976206741" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976206763" elementId="no.hal.learning.exercise.presentation.ExerciseEditorID" action="activated" inputUri="platform:/resource/ovinger/src/test/java/setupcheck/simpleclass.ex"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976208650" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976208673" elementId="no.hal.learning.exercise.presentation.ExerciseEditorID" action="deactivated" inputUri="platform:/resource/ovinger/src/test/java/setupcheck/simpleclass.ex"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976208708" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976208730" elementId="no.hal.learning.exercise.presentation.ExerciseEditorID" action="closed" inputUri="platform:/resource/ovinger/src/test/java/setupcheck/simpleclass.ex"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976213152" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976213175" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976804527" elementId="org.eclipse.jdt.ui.ModuleInfoEditor" action="opened" inputUri="platform:/resource/ovinger/src/main/java/module-info.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976804595" elementId="org.eclipse.jdt.ui.ModuleInfoEditor" action="broughtToTop" inputUri="platform:/resource/ovinger/src/main/java/module-info.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976804643" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976804702" elementId="org.eclipse.jdt.ui.ModuleInfoEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/module-info.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976807558" elementId="org.eclipse.jdt.ui.ModuleInfoEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/module-info.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976807631" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976919271" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976919340" elementId="org.eclipse.jdt.ui.ModuleInfoEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/module-info.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976921607" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976921634" elementId="org.eclipse.jdt.ui.ModuleInfoEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/module-info.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976921673" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976921713" elementId="org.eclipse.jdt.ui.ModuleInfoEditor" action="closed" inputUri="platform:/resource/ovinger/src/main/java/module-info.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976940843" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976940868" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610976958863" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977061903" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977061942" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977064818" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977064835" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977073985" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977192172" elementId="org.eclipse.ui.DefaultTextEditor" action="opened" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/README.txt"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977192224" elementId="org.eclipse.ui.DefaultTextEditor" action="broughtToTop" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/README.txt"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977192250" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977192305" elementId="org.eclipse.ui.DefaultTextEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/README.txt"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977196473" elementId="org.eclipse.ui.DefaultTextEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/README.txt"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977196492" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977205163" elementId="org.eclipse.mylyn.wikitext.ui.editor.markupEditor" action="opened" inputUri="platform:/resource/ovinger/oppgavetekster/oving1/Account.md"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977205210" elementId="org.eclipse.mylyn.wikitext.ui.editor.markupEditor" action="broughtToTop" inputUri="platform:/resource/ovinger/oppgavetekster/oving1/Account.md"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977205308" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977205383" elementId="org.eclipse.mylyn.wikitext.ui.editor.markupEditor" action="activated" inputUri="platform:/resource/ovinger/oppgavetekster/oving1/Account.md"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977209336" elementId="org.eclipse.ui.DefaultTextEditor" action="broughtToTop" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/README.txt"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977209359" elementId="org.eclipse.mylyn.wikitext.ui.editor.markupEditor" action="deactivated" inputUri="platform:/resource/ovinger/oppgavetekster/oving1/Account.md"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977209453" elementId="org.eclipse.ui.DefaultTextEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/README.txt"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977209501" elementId="org.eclipse.mylyn.wikitext.ui.editor.markupEditor" action="closed" inputUri="platform:/resource/ovinger/oppgavetekster/oving1/Account.md"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977213055" elementId="org.eclipse.ui.DefaultTextEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/README.txt"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977213085" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977361354" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="opened" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Account.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977361376" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Account.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977361414" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977361450" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Account.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977365435" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Account.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977365460" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977365856" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="opened" inputUri="platform:/resource/ovinger/src/test/java/stateandbehavior/AccountTest.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977365857" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/ovinger/src/test/java/stateandbehavior/AccountTest.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977365910" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977365951" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/test/java/stateandbehavior/AccountTest.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977371937" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/test/java/stateandbehavior/AccountTest.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977371957" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977373268" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Account.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977373292" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977373337" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Account.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977374970" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/DownCounter.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977374999" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Account.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977375016" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/DownCounter.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977376002" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Account.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977376026" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/DownCounter.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977376042" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Account.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977376057" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/DownCounter.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977377380" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Average.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977378363" elementId="org.eclipse.ui.DefaultTextEditor" action="broughtToTop" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/README.txt"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977378370" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Account.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977378406" elementId="org.eclipse.ui.DefaultTextEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/README.txt"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977379563" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Account.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977379588" elementId="org.eclipse.ui.DefaultTextEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/README.txt"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977379619" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Account.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977379632" elementId="org.eclipse.ui.DefaultTextEditor" action="closed" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/README.txt"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977407563" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Account.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977407583" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977487958" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="opened" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977487963" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977488010" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977488053" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977490310" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977490328" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977506600" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="opened" inputUri="platform:/resource/foreksempel/src/main/java/of2/kode/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977506601" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/foreksempel/src/main/java/of2/kode/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977506653" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977506693" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/foreksempel/src/main/java/of2/kode/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977518963" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/foreksempel/src/main/java/of2/kode/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977518982" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977521257" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977521291" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977521337" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977528729" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/foreksempel/src/main/java/of2/kode/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977528763" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977528782" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/foreksempel/src/main/java/of2/kode/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977535862" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977535894" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/foreksempel/src/main/java/of2/kode/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977535916" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977536758" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/foreksempel/src/main/java/of2/kode/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977536791" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977536808" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/foreksempel/src/main/java/of2/kode/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977541659" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977541689" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/foreksempel/src/main/java/of2/kode/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977541704" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977550078" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/foreksempel/src/main/java/of2/kode/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977550107" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977550123" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/foreksempel/src/main/java/of2/kode/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977551950" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977551982" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/foreksempel/src/main/java/of2/kode/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610977551998" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610979593658" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/ovinger/src/test/java/stateandbehavior/AccountTest.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610979598128" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Account.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610979599192" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/foreksempel/src/main/java/of2/kode/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610979599226" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610979599256" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/foreksempel/src/main/java/of2/kode/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610979600734" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610979600775" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/foreksempel/src/main/java/of2/kode/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610979600793" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610979600810" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/foreksempel/src/main/java/of2/kode/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610979601772" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981504042" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981504151" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981521554" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="opened" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981521556" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981521596" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981521643" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981583432" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981583453" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981584562" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="opened" inputUri="platform:/resource/foreksempel/src/main/java/of2/kode/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981584563" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/foreksempel/src/main/java/of2/kode/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981584599" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981584637" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/foreksempel/src/main/java/of2/kode/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981588210" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/foreksempel/src/main/java/of2/kode/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981588217" elementId="org.eclipse.search.ui.views.SearchView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981588277" elementId="org.eclipse.search.ui.views.SearchView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981592577" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981592611" elementId="org.eclipse.search.ui.views.SearchView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981592672" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981600694" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/foreksempel/src/main/java/of2/kode/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981600727" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981600746" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/foreksempel/src/main/java/of2/kode/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981604882" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981604911" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/foreksempel/src/main/java/of2/kode/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981604928" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981607518" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981607548" elementId="org.eclipse.search.ui.views.SearchView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981608055" elementId="org.eclipse.search.ui.views.SearchView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981608089" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610981985193" elementId="org.eclipse.ui.console.ConsoleView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982207169" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982207201" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982239362" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982239409" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982332746" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982332804" elementId="org.eclipse.ui.console.ConsoleView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982335103" elementId="org.eclipse.ui.console.ConsoleView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982335143" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982361212" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982361229" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982368241" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982368300" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982369274" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982369291" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982370530" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982370555" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982370590" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982371509" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982371516" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982371790" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982371810" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982371843" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982374979" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/foreksempel/src/main/java/of2/kode/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982460476" elementId="org.eclipse.jdt.junit.ResultView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982460498" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982460530" elementId="org.eclipse.jdt.junit.ResultView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982462851" elementId="org.eclipse.ui.console.ConsoleView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982462865" elementId="org.eclipse.jdt.junit.ResultView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982462889" elementId="org.eclipse.ui.console.ConsoleView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982465698" elementId="org.eclipse.ui.console.ConsoleView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982465760" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982601129" elementId="org.eclipse.ui.views.ContentOutline" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982601162" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982601176" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982601202" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982601203" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982601238" elementId="org.eclipse.jdt.junit.ResultView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982601256" elementId="no.hal.learning.exercise.views.ExerciseView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982601273" elementId="org.eclipse.ui.views.ProblemView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982601283" elementId="org.eclipse.search.ui.views.SearchView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1610982601307" elementId="org.eclipse.ui.console.ConsoleView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061024414" elementId="no.hal.learning.exercise.views.ExerciseView" action="opened"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061024448" elementId="no.hal.learning.exercise.views.ExerciseView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061024455" elementId="org.eclipse.jdt.junit.ResultView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061024488" elementId="no.hal.learning.exercise.views.ExerciseView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061028194" elementId="org.eclipse.egit.ui.RepositoriesView" action="opened"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061028274" elementId="org.eclipse.egit.ui.RepositoriesView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061028291" elementId="no.hal.learning.exercise.views.ExerciseView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061028366" elementId="org.eclipse.egit.ui.RepositoriesView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061033293" elementId="org.eclipse.tm.terminal.view.ui.TerminalsView" action="opened"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061033338" elementId="org.eclipse.tm.terminal.view.ui.TerminalsView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061033347" elementId="org.eclipse.egit.ui.RepositoriesView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061033378" elementId="org.eclipse.tm.terminal.view.ui.TerminalsView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061034644" elementId="org.eclipse.tm.terminal.view.ui.TerminalsView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061034735" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Digit.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061040466" elementId="org.eclipse.ui.views.ProblemView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061040489" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Digit.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061040516" elementId="org.eclipse.ui.views.ProblemView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061042303" elementId="org.eclipse.search.ui.views.SearchView" action="opened"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061042345" elementId="org.eclipse.search.ui.views.SearchView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061042368" elementId="org.eclipse.ui.views.ProblemView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061042402" elementId="org.eclipse.search.ui.views.SearchView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061043775" elementId="org.eclipse.ui.console.ConsoleView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061043790" elementId="org.eclipse.search.ui.views.SearchView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061043810" elementId="org.eclipse.ui.console.ConsoleView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061052063" elementId="org.eclipse.ui.console.ConsoleView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061052143" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Digit.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061105089" elementId="org.eclipse.tm.terminal.view.ui.TerminalsView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061105104" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Digit.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061105137" elementId="org.eclipse.tm.terminal.view.ui.TerminalsView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061106289" elementId="org.eclipse.ui.console.ConsoleView" action="broughtToTop"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061106303" elementId="org.eclipse.tm.terminal.view.ui.TerminalsView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061106321" elementId="org.eclipse.ui.console.ConsoleView" action="activated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061107307" elementId="org.eclipse.ui.console.ConsoleView" action="deactivated"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061107380" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Digit.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061112361" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/UpOrDownCounter.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061112370" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Digit.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061112397" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/UpOrDownCounter.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061114628" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/UpOrDownCounter.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061114664" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Account.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061114685" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Account.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061125403" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/UpOrDownCounter.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061125417" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Account.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061125455" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/UpOrDownCounter.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061126754" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Digit.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061126761" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/UpOrDownCounter.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061126786" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Digit.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061148609" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Digit.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061148653" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="broughtToTop" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Account.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061148697" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="activated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Account.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061167866" elementId="org.eclipse.ui.navigator.ProjectExplorer" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061167901" elementId="net.sourceforge.plantuml.eclipse.views.PlantUmlView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061167910" elementId="org.eclipse.jdt.junit.ResultView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061167930" elementId="no.hal.learning.exercise.views.ExerciseView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061167972" elementId="org.eclipse.egit.ui.RepositoriesView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061167996" elementId="org.eclipse.tm.terminal.view.ui.TerminalsView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061168006" elementId="org.eclipse.ui.views.ProblemView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061168016" elementId="org.eclipse.search.ui.views.SearchView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061168042" elementId="org.eclipse.ui.console.ConsoleView" action="closed"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061168060" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Book.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061168089" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Dog.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061168100" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/minegenkode/src/main/java/ofVanskelig/Car.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061168120" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/Random100.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061168132" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/RandomAverage.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061168140" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/minegenkode/src/main/java/eksempe/DownCounter.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061168159" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/ovinger/src/test/java/stateandbehavior/DigitTest.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061168174" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/UpOrDownCounter.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061168191" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Digit.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061168221" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="deactivated" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Account.java"/>
        <attempts xsi:type="workbench:PartTaskEvent" timestamp="1611061168222" elementId="org.eclipse.jdt.ui.CompilationUnitEditor" action="closed" inputUri="platform:/resource/ovinger/src/main/java/stateandbehavior/Account.java"/>
      </proposals>
    </proposals>
  </exercise:ExerciseProposals>
</xmi:XMI>
