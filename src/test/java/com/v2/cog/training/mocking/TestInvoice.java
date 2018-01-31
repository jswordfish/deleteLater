package com.v2.cog.training.mocking;

import org.junit.Test;
import org.mockito.Mockito;



public class TestInvoice {
	
	@Test
	public void testInvoiceGeneration() {
		EmailService emailService = new EmailService() {
			
			@Override
			public void sentCommumnication(Object object) {
				// TODO Auto-generated method stub
				System.out.println("Dummy Email send");
			}
		};
		
		FaxService faxService = new FaxService() {
			
			@Override
			public void sentCommumnication(Object object) {
				// TODO Auto-generated method stub
				System.out.println("Dummy Fax send");
			}
		};
		
		GenerateInvoiceImpl in = new GenerateInvoiceImpl();// Use Spring to deal with interfaces
		in.setEmailService(emailService);
		//in.setFaxService(faxService);
		in.generateAndDispatchInvoice(null, CustomerPreference.Email);
	}
	
	//@Test
	public void testInvoiceGenerationWithMocking() {
		GenerateInvoiceImpl in = new GenerateInvoiceImpl();// Use Spring to deal with interfaces
		//in.setEmailService(Mockito.mock(EmailService.class));
		in.setFaxService(Mockito.mock(FaxService.class));
		in.generateAndDispatchInvoice(null, CustomerPreference.Fax);
	}

}
