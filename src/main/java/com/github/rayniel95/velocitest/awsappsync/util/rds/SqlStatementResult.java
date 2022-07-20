package com.github.rayniel95.velocitest.awsappsync.util.rds;

import java.util.List;

public class SqlStatementResult {
    int numberOfRecordsUpdated;
    List<Record> records;
    List<ColumnMetadata> columnMetadata;
}

