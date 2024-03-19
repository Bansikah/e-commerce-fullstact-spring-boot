package com.bansikah.ecommerce.customer;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.Then;
import com.tngtech.jgiven.TestScenario;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;


@Test
public class CustomerTests extends ScenarioTest<Void> {  // Use Void as generic type since no dedicated scenario class

    @Test
    public void should_create_customer_and_verify_properties() throws Exception {
        given().a_customer()
                .withFirstName("John")
                .and().withLastName("Doe");

        then().the_customer()
                .hasId(null)  // Assuming ID is auto-generated
                .and().hasFirstName("John")
                .and().hasLastName("Doe");
    }

    public static class CustomerScenario {
        // ... scenario class definition (not used in this example)
    }

    public static class Stage {

        private final Customer customer;

        public Stage(Customer customer) {
            this.customer = customer;
        }

        public Stage withFirstName(String firstName) {
            customer.setFirstName(firstName);
            return this;
        }

        public Stage withLastName(String lastName) {
            customer.setLastName(lastName);
            return this;
        }
    }

    public static class Then {

        private final Customer customer;

        public Then(Customer customer) {
            this.customer = customer;
        }

        public Then hasId(Long expectedId) {
            assertEquals(expectedId, customer.getId());
        }

        public Then hasFirstName(String expectedFirstName) {
            assertEquals(expectedFirstName, customer.getFirstName());
        }

        public Then hasLastName(String expectedLastName) {
            assertEquals(expectedLastName, customer.getLastName());
        }
    }
}
