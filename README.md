# openHAB.binding.comfoair
Expanded ComfoAir binding for openHAB

Command	Command type	Possible value	Description

activate	read - write	0, 1	ComfoAir control:
0 – controled by CC Ease
1 – controled by PC (CC Ease is turned off)

Commands realized as standard by CC Ease

fan_level	read - write	1, 2, 3, 4	Ventilation level:
1 – level A (absence state)
2 – level 1 (low)
3 – level 2 (medium)
4 – level 3 (high)
target_temperatur	read - write	15 ÷ 25 °C
step 0,5	Controlling the comfort temperature
filter_error	read	0, 1	Exceed filter replacement time
(depends on the filter replacement period set in ComfoAir):
0 – time has not been exceeded
1 – time out
filter_error_intern	read	0, 1	Contamination of internal filters inside ComfoAir:
0 – filters clear
1 – filters dirty
filter_error_extern	read	0, 1	Contamination of external filters
(on the ventilation duct):
0 – filters clear
1 – filters dirty
filter_reset	write	1	Reset the number of filter operating hours
error_message	read	string	Current errors: A, A-high, E, EA
			
bypass_mode	read	0, 1	Bypass
0 – closed
1 – opened
ewt_mode	read	0, 1	Geothermal heat exchanger – EWT
0 – off
1 – on
preheater_mode	read	0, 1	Preheater
0 – off
1 – on
enthalpy_mode	read	0, 1	Enthalpy exchanger
0 – off
1 – on
freeze_mode	read	0, 1	Frozen ComfoAir
0 – normal work
1 – frozen
cookerhood_mode	read	0, 1	Cooker hood
0 – off
1 – on
Menu 10
menu20_mode	read	0, 1	Menu 20 (P10)
0 – off
1 – on
menu21_mode	read	0, 1	Menu 21 (P11)
0 – off
1 – on
menu22_mode	read	0, 1	Menu 22 (P12)
0 – off
1 – on
menu23_mode	read	0, 1	Menu 23 (P13)
0 – off
1 – on
menu24_mode	read	0, 1	Menu 24 (P14)
0 – off
1 – on
menu25_mode	read	0, 1	Menu 25 (P15)
0 – off
1 – on
menu26_mode	read	0, 1	Menu 26 (P16)
0 – off
1 – on
menu27_mode	read	0, 1	Menu 27 (P17)
0 – off
1 – on
menu28_mode	read	0, 1	Menu 28 (P18)
0 – off
1 – on
menu29_mode	read	0, 1	Menu 29 (P19)
0 – off
1 – on
Menu 20
cookerhood_delay	read - write	0 ÷ 180 min	Overrun timer for the extractor hood programme. (P20)
bathroom_start_delay	read - write	0 ÷ 15 min	Delay timer for the start position of the bathroom switch (to switch to high position). (P21)
bathroom_end_delay	read - write	0 ÷ 120 min	Overrun timer for the bathroom switch (to switch to normal position). (P22)
level3_delay	read - write	0 ÷ 120 min	Overrun timer for ventilation position 3 (using a wired 3-position switch). (P23)
filter_period	read - write	10 ÷ 26 weeks	Filter replacement counter (P24)
RF_low_delay	read - write	1 ÷ 20 min	RF high – short time (< 2 s) (P25)
RF_high_delay	read - write	1 ÷ 120 min	RF high – logn time (> 2 s) (P26)
L1_end_delay	read - write	0 ÷ 120 min	Time for the Boost setting (3 level ventilation e.g. PARTY PROGRAM) (P27)
cookerhood_speed	read - write	%	Setting the extractor hood ventilation levels (P29)
Menu 30
fan_out_0	read - write	0 ÷ 97 %	Capacity of the exhaust fan – level A (P30)
fan_out_1	read - write	16 ÷ 98 %	Capacity of the exhaust fan – level 1 (P31)
fan_out_2	read - write	17 ÷ 99 %	Capacity of the exhaust fan – level 2 (P32)
fan_out_3	read - write	18 ÷ 100 %	Capacity of the exhaust fan – level 3 (P33)
fan_in_0	read - write	0 ÷ 97 %	Capacity of the supply fan – level A (P34)
fan_in _1	read - write	16 ÷ 98 %	Capacity of the supply fan – level 1 (P35)
fan_in _2	read - write	17 ÷ 99 %	Capacity of the supply fan – level 2 (P36)
fan_in _3	read - write	18 ÷ 100 %	Capacity of the supply fan – level 3 (P37)
outgoing_fan	read	0 ÷ 100 %	Current capacity of the exhaust fan (P38)
incomming_fan	read	0 ÷ 100 %	Current capacity of the supply fan (P39)
Menu 40
heater_temperatur	read	°C	Afterheater temperature (P40)
target_temperatur	read - write	15 ÷ 25 °C
step 0,5	Comfort temperature (P41)
look at CC Ease commands
cookerhood_temperatur	read	°C	Extractor hood temperature (P44)
outdoor_incomming_temperatur	read	°C	Incomming (outside) air temperature (P45)
indoor_incomming_temperatur	read	°C	Incomming (supply) air temperature (P46)
indoor_outgoing_temperatur	read	°C	Outgoing (return) air temperature (P47)
outdoor_outgoing_temperatur	read	°C	Outgoing (exhaust) air temperature (P48)
ewt_temperatur	read	°C	EWT sensor temperature (P49)
Menu 50
is_chimney	read - write	0, 1	Fire programme (P50)
0 – off
1 – on
is_preheater	read - write	0, 1	Preheater (P51)
0 – not installed
1 – installed
preheater_option	read - write	0, 1, 2, 3	Setting of the preheater (P52)
0 – guaranteed protection
1 – high protection
2 – nominal protection
3 – economy
is_cookerhood	read - write	0, 1	Extractor hood (P53)
0 – not installed
1 – installed
is_bypass	read - write	0, 1	Bypass (P54)
0 – not installed
1 – installed
is_heater	read - write	0, 1, 2	Afterheater (P55)
0 – not installed
1 – installed
2 – installed and regulated by a pulse width modulation signal (PWM)
recu_level	read - write	0, 1, 2	Required air volume (P56)
0 – normal (nL)
1 – high (HL)
2 – normal (nL)
recu_type	read - write	1, 2	ComfoAir type (P57)
1 – left-hand version (Li)
2 – right-hand version (Re)
analog_mode	read - write	0, 1	Controller priorities (P58)
0 – with analogue inputs
1 – without analogue inputs
is_enthalpy	read - write	0, 1, 2	Enthalpy exchanger (P59)
0 – not installed
1 – installed with RH sensor
2 – installed without RH sensor
Menu 60
is_ewt	read - write	0, 1, 2	Geothermal heat exchanger – EWT (P60)
0 – uninstalled
1 – installed
2 – installed, unregulated
ewt_speed	read - write	0 ÷ 99 %	Setting the percentage by which the supply fan must increase its speed when the valve of the EWT is opened. (P61)
ewt_temperatur_low	read - write	0 ÷ 15 °C	EWT temperaturę low (below which EWT will turned on) (P62)
ewt_temperatur_high	read - write	10 ÷ 25 °C	EWT temperaturę high (above which EWT will turned on) (P63)
heater_target_temperatur	read - write	5 ÷ 40 °C	Afterheater temperature required (P64)
Menu 70
software_main_version	read		Current software – major version (P70)
software_minor_version	read		Current software – minor version (P70)
software_beta_version	read		Current software – beta version
errorA_current	read	1, 2, 4, 8, 16, 32, 64, 128	Current error A
1 – A1
…
128 – A8
errorAhigh_current	read	1, 2, 4, 8, 16, 32, 64, 128	Current error A high
1 – A9
…
64 – A15
128 – A0
errorE_current	read	1, 2, 4, 8, 16, 32, 64, 128	Current error E
1 – E1
…
128 – E8
errorEA_current	read	1, 2, 4, 8, 16, 32, 64, 128	Current error EA
1 – EA1
…
128 – EA8
errorA_last	read	1, 2, 4, 8, 16, 32, 64, 128	Last error A (P71)
1 – A1
…
128 – A8
errorAhigh_last	read	1, 2, 4, 8, 16, 32, 64, 128	Last error A high (P71)
1 – A9
…
64 – A15
128 – A0
errorE_last	read	1, 2, 4, 8, 16, 32, 64, 128	Last error E (P71)
1 – E1
…
128 – E8
errorEA_last	read	1, 2, 4, 8, 16, 32, 64, 128	Last error EA (P71)
1 – EA1
…
128 – EA8
errorA_prelast	read	1, 2, 4, 8, 16, 32, 64, 128	Prelast error A (P72)
1 – A1
…
128 – A8
errorAhigh_prelast	read	1, 2, 4, 8, 16, 32, 64, 128	Prelast error A high (P72)
1 – A9
…
64 – A15
128 – A0
errorE_prelast	read	1, 2, 4, 8, 16, 32, 64, 128	Prelast error E (P72)
1 – E1
…
128 – E8
errorEA_prelast	read	1, 2, 4, 8, 16, 32, 64, 128	Prelast error EA (P72)
1 – EA1
…
128 – EA8
errorA_preprelast	read	1, 2, 4, 8, 16, 32, 64, 128	Pre-prelast error A (P73)
1 – A1
…
128 – A8
errorAhigh_preprelast	read	1, 2, 4, 8, 16, 32, 64, 128	Pre-prelast error A high (P73)
1 – A9
…
64 – A15
128 – A0
errorE_preprelast	read	1, 2, 4, 8, 16, 32, 64, 128	Pre-prelast error E (P73)
1 – E1
…
128 – E8
errorEA_preprelast	read	1, 2, 4, 8, 16, 32, 64, 128	Pre-prelast error EA (P73)
1 – EA1
…
128 – EA8
error_reset	write	1	Resseting errors (P74)
recu_reset	write	1	General reset (P75)
recu_autotest	write	1	Self test (P76)
filter_reset	write	1	Resseting filter counter (P77)
look at CC Ease commands
Menu 80
analog1_mode	read - write	0, 1	Analogue input 1 (P80)
0 – controlling
1 – programing
analog2_mode	read - write	0, 1	Analogue input 2 (P81)
0 – controlling
1 – programing
analog1_min	read - write	0 ÷ 100 %	Analogue input 1 – min. setting (P82)
analog1_max	read - write	0 ÷ 100 %	Analogue input 1 – max. setting (P83)
analog2_min	read - write	0 ÷ 100 %	Analogue input 2 – min. setting (P84)
analog2_max	read - write	0 ÷ 100 %	Analogue input 2 – max. setting (P85)
is_analog1	read - write	0, 1	Analogue input 1 (P86)
0 – not installed
1 – installed
is_analog2	read - write	0, 1	Analogue input 2 (P87)
0 – not installed
1 – installed
analog1_value	read - write	0 ÷ 100 %	Analogue input 1 – set point (P88)
analog2_value	read - write	0 ÷ 100 %	Analogue input 2 – set point (P89)
analog3_mode	read - write	0, 1	Analogue input 3 (P180)
0 – controlling
1 – programing
analog4_mode	read - write	0, 1	Analogue input 4 (P181)
0 – controlling
1 – programing
analog3_min	read - write	0 ÷ 100 %	Analogue input 3 – min. setting (P182)
analog3_max	read - write	0 ÷ 100 %	Analogue input 3 – max. setting (P183)
analog4_min	read - write	0 ÷ 100 %	Analogue input 4 – min. setting (P184)
analog4_max	read - write	0 ÷ 100 %	Analogue input 4 – max. setting (P185)
is_analog3	read - write	0, 1	Analogue input 3 (P186)
0 – not installed
1 – installed
is_analog4	read - write	0, 1	Analogue input 4 (P187)
0 – not installed
1 – installed
analog3_value	read - write	0 ÷ 100 %	Analogue input 3 – set point (P188)
analog4_value	read - write	0 ÷ 100 %	Analogue input 4 – set point (P189)
Menu 90
chimney_mode	read	0, 1	Fire programme (P90)
0 – off
1 – on
bypass_mode	read	0, 1	Bypass (P91)
look at CC Ease commands
0 – closed
1 – opened
ewt_mode	read	0, 1	Geothermal heat excharger – EWT (P92)
look at CC Ease commands
0 – off
1 – on
heater_mode	read	0, 1	Afterheater (P93)
0 – off
1 – on
control_mode	read	0, 1	Analogue inputs (P94)
0 – off
1 – on
preheater_mode	read	0, 1	Preheater (P95)
look at CC Ease commands
0 – off
1 – on
cookerhood_mode	read	0, 1	Extractor hood (P96)
look at CC Ease commands
0 – off
1 – on
enthalpy_mode	read	0, 1	Enthalpy (P97)
look at CC Ease commands
0 – off
1 – on
Komendy dodatkowe
filter_running	read	h	Counter of filter hours (from resseting)
fan_out_efficiency	read	0 ÷ 100 %	Efficiency of the exhaust fan
fan_in_efficiency	read	0 ÷ 100 %	Efficiency of the supply fan
fan_out_speed	read	RPM	Speed of the exhaust fan
fan_in_speed	read	RPM	Speed of the supply fan
is_T1_sensor	read	0, 1	Inlet temperature sensor
0 – not installed
1 – installed
is_T2_sensor	read	0, 1	Supply temperature sensor
0 – not installed
1 – installed
is_T3_sensor	read	0, 1	Return temperature sensor
0 – not installed
1 – installed
is_T4_sensor	read	0, 1	Exhaust temperature sensor
0 – not installed
1 – installed
is_EWT_sensor	read	0, 1	EWT temperature sensor
0 – not installed
1 – installed
is_heater_sensor	read	0, 1	Afterheater temperature sensor
0 – not installed
1 – installed
is_cookerhood_sensor	read	0, 1	Extractor hood temperature sensor
0 – not installed
1 – installed
is_L1_switch	read	0, 1	Switch L1
0 – not installed
1 – installed
is_L2_switch	read	0, 1	Switch L2
0 – not installed
1 – installed
is_bathroom_switch	read	0, 1	Bathroom switch
0 – not installed
1 – installed
is_bathroom2_switch	read	0, 1	Bathroom switch 2 (luxe)
0 – not installed
1 – installed
is_cookerhood_switch	read	0, 1	Extractor hood switch
0 – not installed
1 – installed
is_external_filter	read	0, 1	External filter
0 – not installed
1 – installed
is_WTW	read	0, 1	Heat recovery (WTW)
0 – not installed
1 – installed
bypass_season	read	0, 1	Bypass summer mode
0 – winter
1 – summer
preheater_valve	read	0, 1, 2	Preheater – valve state
0 – opened
1 – closed
2 – unknown
preheater_frost_protect	read	0, 1	Preheater – freezing protection 
0 – off
1 – on
preheater_heating	read	0, 1	Preheater – heating
0 – off
1 – on
preheater_frost_time	read	min	Preheater – freezing time
heater_efficiency	read - write		Afterheater – efficiency
heater_power	read - write		Afterheater power (I – parameter)
level0_time	read	h	Absent level working hours 
level1_time	read	h	Low level working hours
level2_time	read	h	Medium level working hours
level3_time	read	h	High level working hours
preaheater_time	read	h	Preheater working hours
bypass_time	read	h	Bypass opening hours
enthalpy_temperatur	read	°C	Enthalpy temperature sensor
enthalpy_humidity	read	0 ÷ 100 %	Enthalpy humidity sensor
enthalpy_level	read	%	Enthalpy coefficient
enthalpy_time	read	0 ÷ 240	Enthalpy timer
0 = 0 min
…
240 = 2880 min
freeze_time	read	h	ComfoAir freezing hours
analog1_negative	read - write	0, 1	Analogue input 1
0 – positive
1 – negative
analog2_negative	read - write	0, 1	Analogue input 2
0 – positive
1 – negative
analog3_negative	read - write	0, 1	Analogue input 3
0 – positive
1 – negative
analog4_negative	read - write	0, 1	Analogue input 4
0 – positive
1 – negative
analog1_volt	read	0 ÷ 10 V	Voltage on Analog input 1
analog2_volt	read	0 ÷ 10 V	Voltage on Analog input 2
analog3_volt	read	0 ÷ 10 V	Voltage on Analog input 3
analog4_volt	read	0 ÷ 10 V	Voltage on Analog input 4
RF_mode	read - write	0, 1	Radio control RF
0 – controlling
1 – programing
RF_min	read - write	0 ÷ 100 %	Radio control RF – min. setting
RF_max	read - write	0 ÷ 100 %	Radio control RF – max. setting
is_RF	read - write	0, 1	Radio control RF
0 – not installed
1 – installed
RF_value	read - write	0 ÷ 100 %	Radio control RF – set point
RF_negative	read - write	0, 1	Radio control RF
0 – positive
1 – negative
