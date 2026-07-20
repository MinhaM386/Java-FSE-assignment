package com.cognizant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    void testExternalApi() {

        // Create a mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub the method
        when(mockApi.getData()).thenReturn("Mock Data");

        // Inject the mock into the service
        MyService service = new MyService(mockApi);

        // Call the service
        String result = service.fetchData();

        // Verify the result
        assertEquals("Mock Data", result);
    }
}
