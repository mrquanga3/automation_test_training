package career;

import java.util.List;

import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class RunTest {
Class[] cls = {VerifyDropDownList.class, VerifyMultiSelect.class};
Result result = JUnitCore.runClasses(ParallelComputer.classes(), cls);
List<Failure> failure = result.getFailures();

}
