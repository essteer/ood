package com.fdmgroup.tdd.groupcontroller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

public class GroupControllerTest {
	
	GroupController groupController;
	String mockTraineeUsername = "mockTraineeUsername";
	
	@Mock
	DatabaseReader mockDatabaseReader;
	
	@Mock
	DatabaseWriter mockDatabaseWriter;
	
	@Mock
	Trainee mockTrainee;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
		this.groupController = new GroupController(mockDatabaseReader, mockDatabaseWriter);
	}
	
	@Test
	@DisplayName("GroupController can be initialised")
	public void test_GroupController_CanBeInitialised() {
		assertDoesNotThrow(() -> new GroupController(mockDatabaseReader, mockDatabaseWriter));
	}
	
	@Test
	@DisplayName("GroupController implements getAllTrainees() method of GroupControllerService interface")
	public void test_GroupController_ImplementsGetAllTraineesMethodOfGroupControllerServiceInterface() {
		assertDoesNotThrow(() -> groupController.getAllTrainees());
	}
	
	@Test
	@DisplayName("getAllTrainees() returns Map<String,Trainee> object")
	public void test_getAllTrainees_ReturnsObjectOfTypeMapWithStringKeysAndTraineeValues() {
		assertTrue(groupController.getAllTrainees() instanceof Map<String,Trainee>);
	}
	
	@Test
	@DisplayName("getAllTrainees() makes one call to readGroup() method of DatabaseReader")
	public void test_getAllTrainees_MakesOneCallToReadGroupMethodOfDatabaseReader_WhenCalled() {
		groupController.getAllTrainees();
		verify(mockDatabaseReader, times(1)).readGroup();
	}
	
	@Test
	@DisplayName("getAllTrainees() returns Map<String,Trainee> object obtained from readGroup()")
	public void test_getAllTrainees_ReturnsExpectedMapObjectFromReadGroupMethodOfDatabaseReader_WhenCalled() {
		
		Map<String,Trainee> expected = new HashMap<>();
		expected.put("mockKey", mockTrainee);
		when(mockDatabaseReader.readGroup()).thenReturn(expected);
			
		Map<String,Trainee> actual = groupController.getAllTrainees();
		
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("GroupController implements removeTraineeByUsername() method of GroupControllerService interface")
	public void test_GroupController_ImplementsRemoveTraineeByUsernameMethodOfGroupControllerServiceInterface() {
		assertDoesNotThrow(() -> groupController.removeTraineeByUsername(mockTraineeUsername));
	}
	
	@Test
	@DisplayName("removeTraineeByUsername() passes traineeUsername to deleteTraineeByUsername() method of DatabaseWriter")
	public void test_removeTraineeByUsername_CallsDeleteTraineeByUsernameMethodOfDatabaseWriter_WithSameTraineeUsername() {
		groupController.removeTraineeByUsername(mockTraineeUsername);
		verify(mockDatabaseWriter, times(1)).deleteTraineeByUsername(mockTraineeUsername);
	}
	
	@Test
	@DisplayName("GroupController implements addTrainee() method of GroupControllerService interface")
	public void test_GroupController_ImplementsAddTraineeMethodOfGroupControllerServiceInterface() {
		assertDoesNotThrow(() -> groupController.addTrainee(mockTrainee));
	}
	
	@Test
	@DisplayName("addTrainee() passess Trainee to addTrainee() method of DatabaseWriter")
	public void test_GroupControllerAddTraineeMethod_MakesSingleCallToDatabaseWriterAddTraineeMethod_WhenCalled() {
		groupController.addTrainee(mockTrainee);
		verify(mockDatabaseWriter, times(1)).addTrainee(mockTrainee);
	}
	
	
}
