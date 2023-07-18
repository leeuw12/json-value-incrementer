package com.project.dao;

import com.project.exception.ImpossibleToReturnException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
@Log4j2
@RequiredArgsConstructor
public class CounterDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String QUERY_INCREASE_COUNTER = """
                UPDATE sk_example_table
                SET obj = jsonb_set(obj, '{current}', to_jsonb(? + (obj->>'current')::bigint))
                WHERE id = ?
                RETURNING obj->>'current' AS current_value
            """;


    public int update(int id, int valueAdd) {
        Integer currentResult = 0;
        Object[] arr = {valueAdd, id};
        currentResult = jdbcTemplate.queryForObject(QUERY_INCREASE_COUNTER, arr, Integer.class);
        return currentResult;
    }
}



