import mysql.connector as sqlcon
from prettytable import PrettyTable


class DBHelper:
    # Connection
    conn = sqlcon.connect(
        host="localhost",
        user="root",
        password="",
        database="python_db"
    )
    # Cursor
    cr = conn.cursor()
    # Choice
    choice = 0

    def __init__(self):
        print("1. View Tables")
        print("2. Create New Table")
        print("3. Truncate Tables")
        print("4. Drop Table")
        print("5. View Record")
        print("6. Insert Record")
        print("7. Update Record")
        print("8. Delete Record")
        self.choice = int(input("Enter Your Choice : "))

        # View Tables
        if self.choice == 1:
            get_tbl = "show tables"
            self.cr.execute(get_tbl)
            data = self.cr.fetchall()
            table = PrettyTable()
            table.field_names = [i[0] for i in self.cr.description]
            for rows in data:
                table.add_row(rows)
            print(table)

        # Create New Table
        elif self.choice == 2:
            table_name = input("Enter table name: ")
            columns = []
            while True:
                column_name = input("Enter column name (leave blank to finish): ")
                if column_name == "":
                    break
                column_type = input("Enter column data type: ")
                column = f"{column_name} {column_type}"
                columns.append(column)
            columns_str = ', '.join(columns)
            qry = f"CREATE TABLE {table_name} ({columns_str})"
            self.cr.execute(qry)
            self.conn.commit()
            print("Table Created Successfully")
            self.cr.execute(f"DESCRIBE {table_name}")
            data = self.cr.fetchall()
            table = PrettyTable()
            table.field_names = [i[0] for i in self.cr.description]
            for rows in data:
                table.add_row(rows)
            print(table)

        # Truncate Tables
        elif self.choice == 3:
            table_name = input("Enter Table Name : ")
            qry = "TRUNCATE TABLE " + table_name
            self.cr.execute(qry)
            print("Table Truncated Successfully")

        # Drop Table
        elif self.choice == 4:
            table_name = input("Enter Table Name : ")
            qry = "DROP TABLE " + table_name
            self.cr.execute(qry)
            print("Table Dropped Successfully")

        # View Record
        elif self.choice == 5:
            table_name = input("Enter Table Name : ")
            qry = "SELECT * FROM " + table_name
            self.cr.execute(qry)
            data = self.cr.fetchall()
            table = PrettyTable()
            table.field_names = [i[0] for i in self.cr.description]
            for rows in data:
                table.add_row(rows)
            print(table)

        # Insert Data
        elif self.choice == 6:
            table_name = input("Enter Table Name : ")
            self.cr.execute(f"DESCRIBE {table_name}")
            data = self.cr.fetchall()
            columns = [col[0] for col in data]
            types = [col[1] for col in data]
            values = []
            for i in range(len(columns)):
                value = input(f"Enter value for {columns[i]} ({types[i]}): ")
                values.append(value)
            qry = f"INSERT INTO {table_name} ({', '.join(columns)}) VALUES ({', '.join(['%s'] * len(values))})"
            self.cr.execute(qry, values)
            self.conn.commit()
            print(self.cr.rowcount, "record inserted.")

        # Update Record
        elif self.choice == 7:
            table_name = input("Enter Table Name : ")
            record_id = input("Enter the ID of the record to be updated : ")
            self.cr.execute(f"DESCRIBE {table_name}")
            data = self.cr.fetchall()
            columns = [col[0] for col in data]
            types = [col[1] for col in data]
            values = []
            fetchdt = f"SELECT * FROM {table_name} WHERE {columns[0]} = " + record_id
            self.cr.execute(fetchdt)
            data = self.cr.fetchall()
            table = PrettyTable()
            table.field_names = [i[0] for i in self.cr.description]
            for rows in data:
                table.add_row(rows)
            print(table)
            for i in range(len(columns)):
                value = input(f"Enter value for {columns[i]} ({types[i]}): ")
                values.append(value)
            set_clause = ', '.join([f"{columns[i]} = %s" for i in range(len(columns))])
            qry = f"UPDATE {table_name} SET {set_clause} WHERE {columns[0]} = %s"
            values.append(record_id)  # add the record ID to the values list
            self.cr.execute(qry, tuple(values))
            self.conn.commit()
            print(self.cr.rowcount, "record updated.")

        # Delete Record
        elif self.choice == 8:
            table_name = input("Enter Table Name : ")
            record_id = input("Enter the ID of the record to be deleted : ")
            self.cr.execute(f"DESCRIBE {table_name}")
            data = self.cr.fetchall()
            columns = [col[0] for col in data]
            qry = f"DELETE FROM {table_name} WHERE {columns[0]} = " + record_id
            self.cr.execute(qry)
            self.conn.commit()
            print(self.cr.rowcount, "record deleted.")


exe = True
while exe:
    main = DBHelper()
    temp = int(input("Press 1 For Continue..."))
    if temp != 1:
        exe = False
        main.cr.close()
        main.conn.close()
