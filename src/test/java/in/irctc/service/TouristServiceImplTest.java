package in.irctc.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import in.irctc.dao.TouristRepo;
import in.irctc.model.Tourist;
@SpringBootTest
public class TouristServiceImplTest {

	private static final Object Tourist = null;

	@Mock
	private TouristRepo repo;
	
	private TouristService service;
	
	private AutoCloseable autoClosable;
	
	Tourist tourist;
	
	@BeforeEach
	void setUp()
	{
		autoClosable=MockitoAnnotations.openMocks(this);
		service=new TouristServiceImpl(repo);
	
		 tourist =new Tourist(1,"abc","nan","vel","30 min",80);
	}
	@Test
	 void testRegisterTourist()
	 {
		 mock(Tourist.class);
		 mock(TouristRepo.class);
		 
		 when(repo.save(tourist)).thenReturn(tourist);
		assertThat(service.registerTourist(tourist)).isEqualTo(tourist);
	 }
	
	@Test
	void testFindById()
	{
		mock(Tourist.class);
		 mock(TouristRepo.class);
		 when(repo.findById(1)).thenReturn(Optional.ofNullable(tourist));
		 assertThat(service.findById(1).getName()).isEqualTo(tourist.getName());
	}
	
	@Test
	void testUpdateTourist()
	{
		mock(Tourist.class);
		 mock(TouristRepo.class);
		 when(repo.findById(1)).thenReturn(Optional.ofNullable(tourist));
		 assertThat(service.findById(1).getName()).isEqualTo(tourist.getName());
		 when(repo.save(tourist)).thenReturn(tourist);
		assertThat(service.updateTourist(tourist.getId(),tourist)).isEqualTo(tourist);
	}
	
	@Test
	void testDeleteTourist()
	{
		
		mock(Tourist.class);
		 mock(TouristRepo.class,Mockito.CALLS_REAL_METHODS);
		 when(repo.findById(1)).thenReturn(Optional.ofNullable(tourist));
		 assertThat(service.findById(1).getName()).isEqualTo(tourist.getName());
		doAnswer(Answers.CALLS_REAL_METHODS). when(repo).deleteById(any());
		 assertThat(service.deleteTourist(1)).isEqualTo(tourist);
	}
	
	@AfterEach
	void tearDown() throws Exception
	{
		autoClosable.close();
	}
	
}
