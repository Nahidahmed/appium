package test;

import org.testng.annotations.Test;

public class sizebasics {
	@Test(groups="smoke")
	public void Demo1() {
		System.out.println("Hello Size");
	}

	@Test
	public void Demo2() {
		System.out.println("Hello Size, Again");
	}

	@Test
	public void sizemembership_Login() {
		System.out.println("Test Size Membership login");
	}

	@Test
	public void sizemembership_Loyalty() {
		System.out.println("Test Size Membership Loyalty");
	}

	@Test
	public void sizemembership_Account() {
		System.out.println("Test Size Membership A/c");
	}

}
