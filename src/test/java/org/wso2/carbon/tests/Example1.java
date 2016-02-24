/*
*Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*WSO2 Inc. licenses this file to you under the Apache License,
*Version 2.0 (the "License"); you may not use this file except
*in compliance with the License.
*You may obtain a copy of the License at
*
*http://www.apache.org/licenses/LICENSE-2.0
*
*Unless required by applicable law or agreed to in writing,
*software distributed under the License is distributed on an
*"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*KIND, either express or implied.  See the License for the
*specific language governing permissions and limitations
*under the License.
*/
package org.wso2.carbon.tests;

import org.testng.annotations.*;

public class Example1 {

    @BeforeClass
    public void init() {
        System.out.println("Before class");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("After class");
    }


    @BeforeMethod()
    public void testBeforeMethod() {
        System.out.println("before each method");
    }

    @AfterMethod()
    public void testAfterMethod() {
        System.out.println("after each method");
    }


    @Test()
    public void testMethod1() {
        System.out.println("testMethod1");
    }

    @Test(dependsOnMethods = "testMethod1")
    public void testMethod2() {
        System.out.println("testMethod2");
    }


    //faulty scenarios
    @Test(expectedExceptions = ArithmeticException.class)
    public void testMethod3() {
        int i = 1 / 0;
    }

    @Test(invocationCount = 3)
    public void testMethod4() {
        System.out.println("Test Method 4");
    }

    @Test(timeOut = 5)
    public void testMethod5() {
        while (true) {
            System.out.println("waiting for Test Method 5");
        }
    }


    @DataProvider(name = "myprovider")
    public static Object[][] numbers() {
        return new Object[][]{
                {1, 2},
                {3, 5},
                {7, 3}
        };
    }

    @Test(dataProvider = "myprovider")
    public void testMethod6(int a, int b) {
        System.out.println("A : " + a);
        System.out.println("B : " + b);
    }


    @BeforeSuite()
    public void testMethodBeforeSuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite()
    public void testMethodAfterSuite() {
        System.out.println("After Suite");
    }

    // disable test
    @Test(enabled = false)
    public void testMethodDisabled() {
        System.out.println("testMethod disabled");
    }
}
