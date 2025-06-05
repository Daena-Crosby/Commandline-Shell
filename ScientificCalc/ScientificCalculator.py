#Daena's Calculator & Convertor
#Arthur: Daena Crosby#Last Modified: 28/20/24; 8:00pm

import math
from math import pi, e
import tkinter as tk
from tkinter import messagebox

#Main Window
root = tk.Tk()
root.title("Scientific Calculator")
root.geometry("350x500")

#Entry widget for display
entry = tk.Entry(root, width=25, font=('Arial', 18), borderwidth=5, relief='ridge', justify= 'right')
entry.grid(row=0, column=0, columnspan=5, pady=(10, 20))

# Variable to store the previous answer
prev_answer = None

#Defining Operations
def click_button(value):
    current = entry.get()
    entry.delete(0, tk.END)
    entry.insert(0, current + str(value))

def clear():
    entry.delete(0, tk.END)

# Backspace function to delete the last character
def backspace():
    current_text = entry.get()
    entry.delete(0, tk.END)  # Clear the entry
    entry.insert(0, current_text[:-1])  # Insert the text without the last character

def calculate():
    global prev_answer 
    try:
        result = eval(entry.get())
        entry.delete(0, tk.END)
        entry.insert(0, result)
        prev_answer = result
    except Exception:
        messagebox.showerror("Error", "Invalid Calculation")
        entry.delete(0, tk.END)

# Function to insert previous answer into the entry
def insert_prev_answer():
    if prev_answer is not None:
        entry.insert(tk.END, str(prev_answer))

# Mapping buttons to their respective operations
operations = {
    '√': lambda x: math.sqrt(x),
    'x²': lambda x: x ** 2,
    'x³': lambda x: x ** 3,
    'sin': lambda x: math.sin(math.radians(x)),
    'cos': lambda x: math.cos(math.radians(x)),
    'tan': lambda x: math.tan(math.radians(x)),
    'sin^-1': lambda x: math.asin(math.radians(x)),
    'cos^-1': lambda x: math.acos(math.radians(x)),
    'tan^-1': lambda x: math.atan(math.radians(x)),
    'log': lambda x: math.log10(x),
    'ln': lambda x: math.log(x),
    'π': lambda x: math.pi,
    'e': lambda x: math.e,
}

def calculate_function(operation):
    try:
        value = float(entry.get())
        entry.delete(0, tk.END)
        result = operations[operation](value)
        entry.insert(0, result)
    except ValueError:
        messagebox.showerror("Error", "Invalid Input")
        entry.delete(0, tk.END)

buttons = [
    '7', '8', '9', '+',
    '4', '5', '6', '-',
    '1', '2', '3', '\u00D7',
    '.', '0', '=', '\u00F7'
]

row = 5
col = 0
for button in buttons:
    if button == '=':
        tk.Button(root, text=button, width=8, height=2, command=calculate).grid(row=8, column=3, padx=0, pady=0)
    elif button == '+':
        tk.Button(root, text=button, width=8, height=2, command=calculate).grid(row=6, column=3, padx=0, pady=0)
    elif button == '-':
        tk.Button(root, text=button, width=8, height=2, command=calculate).grid(row=6, column=4, padx=0, pady=0)
    elif button == '\u00D7':
        tk.Button(root, text=button, width=8, height=2, command=calculate).grid(row=7, column=3, padx=0, pady=0)
    elif button == '\u00F7':
        tk.Button(root, text=button, width=8, height=2, command=calculate).grid(row=7, column=4, padx=0, pady=0)
    else:
        tk.Button(root, text=button, width=8, height=2, command=lambda button=button: click_button(button)).grid(row=row, column=col)
    col += 1
    if col > 3:
        col = 0
        row += 1

scientific_buttons = [
    ('√', 2, 0),
    ('x²', 1, 1),
    ('sin', 1, 2),
    ('cos', 1, 3),
    ('tan', 1, 4),
    ('log', 2, 1),
    ('ln', 2, 2),
    ('π', 2, 3),
    ('e', 2, 4)
]

for (text, row, col) in scientific_buttons:
    tk.Button(root, text=text, width=8, height=2, command=lambda text=text: calculate_function(text)).grid(row=row, column=col)

# Clear button
tk.Button(root, text="C", width=8, height=2, command=lambda: entry.delete(0, tk.END)).grid(row=8, column=4)

# Backspace button
tk.Button(root, text="⌫", width=8, height=2, command=backspace).grid(row=5, column=3, padx=0, pady=0)

# Previous Answer button
tk.Button(root, text="Ans", width=8, height=2, command=insert_prev_answer).grid(row=5, column=4, padx=0, pady=0)

root.mainloop()