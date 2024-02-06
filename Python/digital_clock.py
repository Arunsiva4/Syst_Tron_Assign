import time
import tkinter as tk
from tkinter import ttk
from tkinter import colorchooser

win = tk.Tk()
win.title("ARUN.S_DIGITAL_CLOCK")
win.geometry("400x200")

def update_clk():
    hrs = time.strftime("%I")
    mint = time.strftime("%M")
    sec = time.strftime("%S")
    am_pm = time.strftime("%p")
    time_txt = hrs + ":" + mint + ":" + sec + " " + am_pm
    digi_clk.config(text=time_txt)
    digi_clk.after(1000, update_clk)

def change_background_color():
    color = colorchooser.askcolor()[1]
    win.configure(bg=color)

def display_temperature():
    temperature_label.config(text="Temperature: 28°C")

def display_date_month_year():
    current_date = time.strftime("%d")
    current_month = time.strftime("%B")
    current_year = time.strftime("%Y")
    date_month_year_label.config(text=f" {current_date}-{current_month}-{current_year}")

digi_clk = tk.Label(win, text="00:00:00", font="Sans-serif 30 bold")
digi_clk.pack()
color_button = ttk.Button(win, text="Change Background Color", command=change_background_color)
temperature_label = tk.Label(win, text="Temperature: ", font="Sans-serif 12")
temperature_label.pack()
date_month_year_label = tk.Label(win, text="", font="Sans-serif 12")
date_month_year_label.pack()
update_clk()
display_temperature()
display_date_month_year()
color_button.pack()
tk.Label(text="\nCreated By ARUN SIVAKUMAR", font="Sans-serif 15").pack()
win.mainloop()
