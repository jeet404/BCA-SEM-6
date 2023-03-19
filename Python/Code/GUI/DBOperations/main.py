import tkinter as tk

import mysql.connector


class CRUDApp:
    def __init__(self):
        self.root = tk.Tk()
        self.root.title("CRUD Application")
        self.root.geometry("400x300")

        # Labels
        tk.Label(self.root, text="Name").grid(row=0, column=0)
        tk.Label(self.root, text="Email").grid(row=1, column=0)

        # Entry widgets
        self.name_entry = tk.Entry(self.root)
        self.name_entry.grid(row=0, column=1)
        self.email_entry = tk.Entry(self.root)
        self.email_entry.grid(row=1, column=1)

        # Buttons
        tk.Button(self.root, text="Create", command=self.create).grid(row=2, column=0)
        tk.Button(self.root, text="Read", command=self.read).grid(row=2, column=1)
        tk.Button(self.root, text="Update", command=self.update).grid(row=2, column=2)
        tk.Button(self.root, text="Delete", command=self.delete).grid(row=2, column=3)

        # Text widget to display messages
        self.message_text = tk.Text(self.root, height=4, width=40)
        self.message_text.grid(row=3, column=0, columnspan=4)

        # Connect to mysql database
        self.connection = mysql.connector.connect(
            host="localhost",
            user="root",
            password="",
            database="crud_app"
        )

        self.cursor = self.connection.cursor()

        # Create table if it doesn't exist
        self.cursor.execute("""
            CREATE TABLE IF NOT EXISTS user_info (
                id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(255),
                email VARCHAR(255)
            )
        """)

        self.root.mainloop()

    def create(self):
        name = self.name_entry.get()
        email = self.email_entry.get()

        # Insert record into database
        self.cursor.execute("INSERT INTO user_info (name, email) VALUES (%s, %s)", (name, email))
        self.connection.commit()

        self.message_text.insert(tk.END, "Record created.\n")

    def read(self):
        # Select all records from database
        self.cursor.execute("SELECT * FROM user_info")
        records = self.cursor.fetchall()

        # Display records in text widget
        self.message_text.delete("1.0", tk.END)
        for record in records:
            self.message_text.insert(tk.END, f"{record[0]} {record[1]} {record[2]}\n")

    def update(self):
        name = self.name_entry.get()
        email = self.email_entry.get()

        # Update record in database
        self.cursor.execute("UPDATE user_info SET email = %s WHERE name = %s", (email, name))
        self.connection.commit()

        self.message_text.insert(tk.END, "Record updated.\n")

    def delete(self):
        name = self.name_entry.get()

        # Delete record from database
        self.cursor.execute("DELETE FROM user_info WHERE name = %s", (name,))
        self.connection.commit()

        self.message_text.insert(tk.END, "Record deleted.\n")


if __name__ == "__main__":
    app = CRUDApp()
