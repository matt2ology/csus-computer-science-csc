// Description: Test suite module to test LinkedListTest1 and LinkedListTest2.  
// Author: Doan Nguyen 
// Date: 1/8/18 (Updated)
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   LinkedListTest1.class,
   LinkedListTest2.class
})

public class JunitTestSuite {   
} 
