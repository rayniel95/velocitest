package com.github.rayniel95.velocitest.awsappsync.util.rds;

/*
Contains the metadata for a column in AWS RDS.
*/
public class ColumnMetadata {
    // A value that indicates whether an integer column is signed.
    // Type: Boolean
    // Required: No
    boolean isSigned;
    
    // TODO - take a look to default values
    // A value that indicates whether the column contains currency values.
    // Type: Boolean
    // Required: No
    boolean isCurrency;

    // The label for the column.
    // Type: String
    // Required: No
    String label;

    // The precision value of a decimal number column.
    // Type: Integer
    // Required: No
    int precision;

    // The database-specific data type of the column.
    // Type: String
    // Required: No
    String typeName; // NOTE - this can be a enum

    // The scale value of a decimal number column.
    // Type: Integer
    // Required: No
    int scale;

    // A value that indicates whether the column increments automatically.
    // Type: Boolean
    // Required: No
    boolean isAutoIncrement;

    // A value that indicates whether the column is case-sensitive.
    // Type: Boolean
    // Required: No
    boolean isCaseSensitive;

    // The name of the schema that owns the table that includes the column.
    // Type: String
    // Required: No
    String schemaName;

    // The name of the table that includes the column.
    // Type: String
    // Required: No
    String tableName;

    // The type of the column.
    // Type: Integer
    // Required: No
    int type;

    // A value that indicates whether the column is nullable.
    // Type: Integer
    // Required: No
    int nullable;

    // The type of the column.
    // Type: Integer
    // Required: No
    int arrayBaseColumnType;

    // The name of the column.
    // Type: String
    // Required: No
    String name;
}
