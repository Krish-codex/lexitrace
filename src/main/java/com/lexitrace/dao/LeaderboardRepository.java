package com.lexitrace.dao;

import com.lexitrace.models.Leaderboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeaderboardRepository extends JpaRepository<Leaderboard, Long> {

    List<Leaderboard> findByLanguageIdOrderByTotalPointsDesc(Long languageId);

    Optional<Leaderboard> findByUserIdAndLanguageId(Long userId, Long languageId);

    @Query("SELECT lb FROM Leaderboard lb ORDER BY lb.totalPoints DESC")
    List<Leaderboard> findTopUsers();

    @Query("SELECT lb FROM Leaderboard lb WHERE lb.userId = :userId")
    List<Leaderboard> findByUserId(Long userId);

    @Query("SELECT COALESCE(SUM(lb.totalPoints), 0) FROM Leaderboard lb WHERE lb.userId = :userId")
    Integer getTotalPointsByUserId(Long userId);
}
