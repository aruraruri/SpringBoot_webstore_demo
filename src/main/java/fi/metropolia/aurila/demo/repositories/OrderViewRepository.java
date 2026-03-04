package fi.metropolia.aurila.demo.repositories;

import fi.metropolia.aurila.demo.entity.OrderView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface OrderViewRepository extends JpaRepository<OrderView, Integer> {

    List<OrderView> findByStatus(String status);

    @Query("SELECT o FROM OrderView o WHERE o.last_name = :lastName")
    List<OrderView> findByCustomerLastName(@Param("lastName") String lastName);

    @Query("SELECT o FROM OrderView o WHERE o.order_date BETWEEN :startDate AND :endDate")
    List<OrderView> findOrdersBetweenDates(@Param("startDate") Date startDate,
                                           @Param("endDate") Date endDate);
}