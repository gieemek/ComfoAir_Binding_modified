# ComfoAir Binding modified
Expanded ComfoAir binding v.1x for openHAB based on original [org.openhab.binding.comfoair](https://github.com/openhab/openhab1-addons/wiki/comfo-air-binding) v. 1.3.0 written by Holger Hees.

## What's new in this binding ?

Many new commands (read and write) have been added in this binding. The program code was also changed so the sending of the write commands is possible and did not cause problems with the operation of the device.<br/>
Original binding provided 22 commands, including 5 write commands only (eg it allowed to control ventilation levels and reset errors).
This new binding provides 160 commands, including 71 write commands. This gives you the ability to control all ComfoAir settings, available in menus 10 - 90, and even more. This allows for full control of the device.

This binding was tested with the Zehnder ComfoAir 350 ventilation system. As original binding it should work with ComfoAir 550, WHR930 of StorkAir, G90-380 by Wernig and Santos 370 DC to Paul.

### List of commands (original and new ones).

| Command | Read / Write | Possible value | Description |
| :------ | :----------: | :------------: | :---------- |
| activate | read - write | 0, 1 | ComfoAir control:<br/>0 – controled by CC Ease,<br/>1 – controled by PC (CC Ease is turned off) |
| **Commands that take over<br/>the CC Ease functions** | | | |
| fan_level | read - write | 1, 2, 3, 4 | Ventilation level:<br/>1 – level A (absence state)<br/>2 – level 1 (low)<br/>3 – level 2 (medium)<br/>4 – level 3 (high) |
| target_temperatur | read - write | 15 ÷ 25 °C<br/>step 0,5 | Controlling the comfort temperature |
| filter_error | read | 0, 1 | Exceed filter replacement time<br/>(depends on the filter replacement period set in ComfoAir):<br/>0 – time has not been exceeded<br/>1 – time out |
| filter_error_intern | read | 0, 1 | Contamination of internal filters inside ComfoAir:<br/>0 – filters clean<br/>1 – filters dirty |
| filter_error_extern | read | 0, 1 | Contamination of external filters<br/>(on the ventilation duct):<br/>0 – filters clear<br/>1 – filters dirty |
| filter_reset | write | 1 | Reset the number of filter operating hours |
| error_message | read | string | Current errors: A, A-high, E, EA |
| bypass_mode | read | 0, 1 | Bypass<br/>0 – closed<br/>1 – opened |
| ewt_mode | read | 0, 1 | Geothermal heat exchanger – EWT<br/>0 – off<br/>1 – on |
| preheater_mode | read | 0, 1 | Preheater<br/>0 – off<br/>1 – on |
| enthalpy_mode | read | 0, 1 | Enthalpy exchanger<br/>0 – off<br/>1 – on |
| freeze_mode | read | 0, 1 | Frozen ComfoAir<br/>0 – normal work<br/>1 – frozen |
| cookerhood_mode | read | 0, 1 | Cooker hood<br/>0 – off<br/>1 – on |
| **Menu 10** | | | |
| menu20_mode | read | 0, 1 | Menu 20 (P10)<br/>0 – off<br/>1 – on |
| menu21_mode | read | 0, 1 | Menu 21 (P11)<br/>0 – off<br/>1 – on |
| menu22_mode | read | 0, 1 | Menu 22 (P12)<br/>0 – off<br/>1 – on |
| menu23_mode | read | 0, 1 | Menu 23 (P13)<br/>0 – off<br/>1 – on |
| menu24_mode | read | 0, 1 | Menu 24 (P14)<br/>0 – off<br/>1 – on |
| menu25_mode | read | 0, 1 | Menu 25 (P15)<br/>0 – off<br/>1 – on |
| menu26_mode | read | 0, 1 | Menu 26 (P16)<br/>0 – off<br/>1 – on |
| menu27_mode | read | 0, 1 | Menu 27 (P17)<br/>0 – off<br/>1 – on |
| menu28_mode | read | 0, 1 | Menu 28 (P18)<br/>0 – off<br/>1 – on |
| menu29_mode | read | 0, 1 | Menu 29 (P19)<br/>0 – off<br/>1 – on |
| **Menu 20** | | | |
| cookerhood_delay | read - write | 0 ÷ 180 min | Overrun timer for the extractor hood programme. (P20) |
| bathroom_start_delay | read - write | 0 ÷ 15 min | Delay timer for the start position of the bathroom switch (to switch to high position). (P21) |
| bathroom_end_delay | read - write | 0 ÷ 120 min | Overrun timer for the bathroom switch (to switch to normal position). (P22) |
| level3_delay | read - write | 0 ÷ 120 min | Overrun timer for ventilation position 3 (using a wired 3-position switch). (P23) |
| filter_period | read - write | 10 ÷ 26 weeks | Filter replacement counter (P24) |
| RF_low_delay | read - write | 1 ÷ 20 min | RF high – short time (< 2 s) (P25) |
| RF_high_delay | read - write | 1 ÷ 120 min | RF high – logn time (> 2 s) (P26) |
| L1_end_delay | read - write | 0 ÷ 120 min | Time for the Boost setting (3 level ventilation e.g. PARTY PROGRAM) (P27) |
| cookerhood_speed | read - write | % | Setting the extractor hood ventilation levels (P29) |
| Menu 30 | | | |
| fan_out_0 | read - write | 0 ÷ 97 % | Capacity of the exhaust fan – level A (P30) |
| fan_out_1 | read - write | 16 ÷ 98 % | Capacity of the exhaust fan – level 1 (P31) |
| fan_out_2 | read - write | 17 ÷ 99 % | Capacity of the exhaust fan – level 2 (P32) |
| fan_out_3 | read - write | 18 ÷ 100 % | Capacity of the exhaust fan – level 3 (P33) |
| fan_in_0 | read - write | 0 ÷ 97 % | Capacity of the supply fan – level A (P34) |
| fan_in_1 | read - write | 16 ÷ 98 % | Capacity of the supply fan – level 1 (P35) |
| fan_in_2 | read - write | 17 ÷ 99 % | Capacity of the supply fan – level 2 (P36) |
| fan_in_3 | read - write | 18 ÷ 100 % | Capacity of the supply fan – level 3 (P37) |
| outgoing_fan | read | 0 ÷ 100 % | Current capacity of the exhaust fan (P38) |
| incomming_fan | read | 0 ÷ 100 % | Current capacity of the supply fan (P39) |
| Menu 40 | | | |
| heater_temperatur | read | °C | Afterheater temperature (P40) |
| target_temperatur | read - write | 15 ÷ 25 °C step 0,5 | Comfort temperature (P41) look at CC Ease commands |
| cookerhood_temperatur | read | °C | Extractor hood temperature (P44) |
| outdoor_incomming_temperatur | read | °C | Incomming (outside) air temperature (P45) |
| indoor_incomming_temperatur | read | °C | Incomming (supply) air temperature (P46) |
| indoor_outgoing_temperatur | read | °C | Outgoing (return) air temperature (P47) |
| outdoor_outgoing_temperatur | read | °C | Outgoing (exhaust) air temperature (P48) |
| ewt_temperatur | read | °C | EWT sensor temperature (P49) |
| Menu 50 | | | |
| is_chimney | read - write | 0, 1 | Fire programme (P50)<br/>0 – off<br/>1 – on |
| is_preheater | read - write | 0, 1 | Preheater (P51)<br/>0 – not installed<br/>1 – installed |
| preheater_option | read - write | 0, 1, 2, 3 | Setting of the preheater (P52)<br/>0 – guaranteed protection<br/>1 – high protection<br/>2 – nominal protection<br/>3 – economy |
| is_cookerhood | read - write | 0, 1 | Extractor hood (P53)<br/>0 – not installed<br/>1 – installed |
| is_bypass | read - write | 0, 1 | Bypass (P54)<br/>0 – not installed<br/>1 – installed |
| is_heater | read - write | 0, 1, 2 | Afterheater (P55)<br/>0 – not installed<br/>1 – installed<br/>2 – installed and regulated by a pulse width modulation signal (PWM) |
| recu_level | read - write | 0, 1, 2 | Required air volume (P56)<br/>0 – normal (nL)<br/>1 – high (HL)<br/>2 – normal (nL) |
| recu_type | read - write | 1, 2 | ComfoAir type (P57)<br/>1 – left-hand version (Li)<br/>2 – right-hand version (Re) |
| analog_mode | read - write | 0, 1 | Controller priorities (P58)<br/>0 – with analogue inputs<br/>1 – without analogue inputs |
| is_enthalpy | read - write | 0, 1, 2 | Enthalpy exchanger (P59)<br/>0 – not installed<br/>1 – installed with RH sensor<br/>2 – installed without RH sensor |
| Menu 60 | | | |
| is_ewt | read - write | 0, 1, 2 | Geothermal heat exchanger – EWT (P60)<br/>0 – uninstalled<br/>1 – installed<br/>2 – installed, unregulated |
| ewt_speed | read - write | 0 ÷ 99 % | Setting the percentage by which the supply fan must increase its speed when the valve of the EWT is opened. (P61) |
| ewt_temperatur_low | read - write | 0 ÷ 15 °C | EWT temperaturę low (below which EWT will turned on) (P62) |
| ewt_temperatur_high | read - write | 10 ÷ 25 °C | EWT temperaturę high (above which EWT will turned on) (P63) |
| heater_target_temperatur | read - write | 5 ÷ 40 °C | Afterheater temperature required (P64) |
| Menu 70 | | | |
| software_main_version | read | | Current software – major version (P70) |
| software_minor_version | read |  | Current software – minor version (P70) |
| software_beta_version | read |  | Current software – beta version |
| errorA_current | read | 1, 2, 4, 8, 16, 32, 64, 128 | Current error A<br/>1 – A1<br/>…<br/>128 – A8 |
| errorAhigh_current | read | 1, 2, 4, 8, 16, 32, 64, 128 | Current error A high<br/>1 – A9<br/>…<br/>64 – A15<br/>128 – A0 |
| errorE_current | read | 1, 2, 4, 8, 16, 32, 64, 128 | Current error E<br/>1 – E1<br/>…<br/>128 – E8 |
| errorEA_current | read | 1, 2, 4, 8, 16, 32, 64, 128 | Current error EA<br/>1 – EA1<br/>…<br/>128 – EA8 |
| errorA_last | read | 1, 2, 4, 8, 16, 32, 64, 128 | Last error A (P71)<br/>1 – A1<br/>…<br/>128 – A8 |
| errorAhigh_last | read | 1, 2, 4, 8, 16, 32, 64, 128 | Last error A high (P71)<br/>1 – A9<br/>…<br/>64 – A15<br/>128 – A0 |
| errorE_last | read | 1, 2, 4, 8, 16, 32, 64, 128 | Last error E (P71)<br/>1 – E1<br/>…<br/>128 – E8 |
| errorEA_last | read | 1, 2, 4, 8, 16, 32, 64, 128 | Last error EA (P71)<br/>1 – EA1<br/>…<br/>128 – EA8 |
| errorA_prelast | read | 1, 2, 4, 8, 16, 32, 64, 128 | Prelast error A (P72)<br/>1 – A1<br/>…<br/>128 – A8 |
| errorAhigh_prelast | read | 1, 2, 4, 8, 16, 32, 64, 128 | Prelast error A high (P72)<br/>1 – A9<br/>…<br/>64 – A15<br/>128 – A0 |
| errorE_prelast | read | 1, 2, 4, 8, 16, 32, 64, 128 | Prelast error E (P72)<br/>1 – E1<br/>…<br/>128 – E8 |
| errorEA_prelast | read | 1, 2, 4, 8, 16, 32, 64, 128 | Prelast error EA (P72)<br/>1 – EA1<br/>…<br/>128 – EA8 |
| errorA_preprelast | read | 1, 2, 4, 8, 16, 32, 64, 128 | Pre-prelast error A (P73)<br/>1 – A1<br/>…<br/>128 – A8 |
| errorAhigh_preprelast | read | 1, 2, 4, 8, 16, 32, 64, 128 | Pre-prelast error A high (P73)<br/>1 – A9<br/>…<br/>64 – A15<br/>128 – A0 |
| errorE_preprelast | read | 1, 2, 4, 8, 16, 32, 64, 128 | Pre-prelast error E (P73)<br/>1 – E1<br/>…<br/>128 – E8 |
| errorEA_preprelast | read | 1, 2, 4, 8, 16, 32, 64, 128 | Pre-prelast error EA (P73)<br/>1 – EA1<br/>…<br/>128 – EA8 |
| error_reset | write | 1 | Resseting errors (P74) |
| recu_reset | write | 1 | General reset (P75) |
| recu_autotest | write | 1 | Self test (P76) |
| filter_reset | write | 1 | Resseting filter counter (P77)<br/>look at CC Ease commands |
| Menu 80 | | | |
| analog1_mode | read - write | 0, 1 | Analogue input 1 (P80)<br/>0 – controlling<br/>1 – programing |
| analog2_mode | read - write | 0, 1 | Analogue input 2 (P81)<br/>0 – controlling<br/>1 – programing |
| analog1_min | read - write | 0 ÷ 100 % | Analogue input 1 – min. setting (P82) |
| analog1_max | read - write | 0 ÷ 100 % | Analogue input 1 – max. setting (P83) |
| analog2_min | read - write | 0 ÷ 100 % | Analogue input 2 – min. setting (P84) |
| analog2_max | read - write | 0 ÷ 100 % | Analogue input 2 – max. setting (P85) |
| is_analog1 | read - write | 0, 1 | Analogue input 1 (P86)<br/>0 – not installed<br/>1 – installed |
| is_analog2 | read - write | 0, 1 | Analogue input 2 (P87)<br/>0 – not installed<br/>1 – installed |
| analog1_value | read - write | 0 ÷ 100 % | Analogue input 1 – set point (P88) |
| analog2_value | read - write | 0 ÷ 100 % | Analogue input 2 – set point (P89) |
| analog3_mode | read - write | 0, 1 | Analogue input 3 (P180)<br/>0 – controlling<br/>1 – programing |
| analog4_mode | read - write | 0, 1 | Analogue input 4 (P181)<br/>0 – controlling<br/>1 – programing |
| analog3_min | read - write | 0 ÷ 100 % | Analogue input 3 – min. setting (P182) |
| analog3_max | read - write | 0 ÷ 100 % | Analogue input 3 – max. setting (P183) |
| analog4_min | read - write | 0 ÷ 100 % | Analogue input 4 – min. setting (P184) |
| analog4_max | read - write | 0 ÷ 100 % | Analogue input 4 – max. setting (P185) |
| is_analog3 | read - write | 0, 1 | Analogue input 3 (P186)<br/>0 – not installed<br/>1 – installed |
| is_analog4 | read - write | 0, 1 | Analogue input 4 (P187)<br/>0 – not installed<br/>1 – installed |
| analog3_value | read - write | 0 ÷ 100 % | Analogue input 3 – set point (P188) |
| analog4_value | read - write | 0 ÷ 100 % | Analogue input 4 – set point (P189) |
Menu 90 | | | |
| chimney_mode | read | 0, 1 | Fire programme (P90)<br/>0 – off<br/>1 – on |
| bypass_mode | read | 0, 1 | Bypass (P91)<br/>look at CC Ease commands<br/>0 – closed<br/>1 – opened |
| ewt_mode | read | 0, 1 | Geothermal heat excharger – EWT (P92)<br/>look at CC Ease commands<br/>0 – off<br/>1 – on |
| heater_mode | read | 0, 1 | Afterheater (P93)<br/>0 – off<br/>1 – on |
| control_mode | read | 0, 1 | Analogue inputs (P94)<br/>0 – off<br/>1 – on |
| preheater_mode | read | 0, 1 | Preheater (P95)<br/>look at CC Ease commands<br/>0 – off<br/>1 – on |
| cookerhood_mode | read | 0, 1 | Extractor hood (P96)<br/>look at CC Ease commands<br/>0 – off<br/>1 – on |
| enthalpy_mode | read | 0, 1 | Enthalpy (P97)<br/>look at CC Ease commands<br/>0 – off<br/>1 – on |
| Additional commands | | | |
| filter_running | read | h | Counter of filter hours (from resseting) |
| fan_out_efficiency | read | 0 ÷ 100 % | Efficiency of the exhaust fan |
| fan_in_efficiency | read | 0 ÷ 100 % | Efficiency of the supply fan |
| fan_out_speed | read | RPM | Speed of the exhaust fan |
| fan_in_speed | read | RPM | Speed of the supply fan |
| is_T1_sensor | read | 0, 1 | Inlet temperature sensor<br/>0 – not installed<br/>1 – installed |
| is_T2_sensor | read | 0, 1 | Supply temperature sensor<br/>0 – not installed<br/>1 – installed |
| is_T3_sensor | read | 0, 1 | Return temperature sensor<br/>0 – not installed<br/>1 – installed |
| is_T4_sensor | read | 0, 1 | Exhaust temperature sensor<br/>0 – not installed<br/>1 – installed |
| is_EWT_sensor | read | 0, 1 | EWT temperature sensor<br/>0 – not installed<br/>1 – installed |
| is_heater_sensor | read | 0, 1 | Afterheater temperature sensor<br/>0 – not installed<br/>1 – installed |
| is_cookerhood_sensor | read | 0, 1 | Extractor hood temperature sensor<br/>0 – not installed<br/>1 – installed |
| is_L1_switch | read | 0, 1 | Switch L1<br/>0 – not installed<br/>1 – installed |
| is_L2_switch | read | 0, 1 | Switch L2<br/>0 – not installed<br/>1 – installed |
| is_bathroom_switch | read | 0, 1 | Bathroom switch<br/>0 – not installed<br/>1 – installed |
| is_bathroom2_switch | read | 0, 1 | Bathroom switch 2 (luxe)<br/>0 – not installed<br/>1 – installed |
| is_cookerhood_switch | read | 0, 1 | Extractor hood switch<br/>0 – not installed<br/>1 – installed |
| is_external_filter | read | 0, 1 | External filter<br/>0 – not installed<br/>1 – installed |
| is_WTW | read | 0, 1 | Heat recovery (WTW)<br/>0 – not installed<br/>1 – installed |
| bypass_season | read | 0, 1 | Bypass summer mode<br/>0 – winter<br/>1 – summer |
| preheater_valve | read | 0, 1, 2 | Preheater – valve state<br/>0 – opened<br/>1 – closed<br/>2 – unknown |
| preheater_frost_protect | read | 0, 1 | Preheater – freezing protection<br/>0 – off<br/>1 – on |
| preheater_heating | read | 0, 1 | Preheater – heating<br/>0 – off<br/>1 – on |
| preheater_frost_time | read | min | Preheater – freezing time |
| heater_efficiency | read - write |  | Afterheater – efficiency |
| heater_power | read - write |  | Afterheater power (I – parameter) |
| level0_time | read | h | Absent level working hours  |
| level1_time | read | h | Low level working hours |
| level2_time | read | h | Medium level working hours |
| level3_time | read | h | High level working hours |
| preaheater_time | read | h | Preheater working hours |
| bypass_time | read | h | Bypass opening hours |
| enthalpy_temperatur | read | °C | Enthalpy temperature sensor |
| enthalpy_humidity | read | 0 ÷ 100 % | Enthalpy humidity sensor |
| enthalpy_level | read | % | Enthalpy coefficient |
| enthalpy_time | read | 0 ÷ 240 | Enthalpy timer<br/>0 = 0 min<br/>…<br/>240 = 2880 min |
| freeze_time | read | h | ComfoAir freezing hours |
| analog1_negative | read - write | 0, 1 | Analogue input 1<br/>0 – positive<br/>1 – negative |
| analog2_negative | read - write | 0, 1 | Analogue input 2<br/>0 – positive<br/>1 – negative |
| analog3_negative | read - write | 0, 1 | Analogue input 3<br/>0 – positive<br/>1 – negative |
| analog4_negative | read - write | 0, 1 | Analogue input 4<br/>0 – positive<br/>1 – negative |
| analog1_volt | read | 0 ÷ 10 V | Voltage on Analog input 1 |
| analog2_volt | read | 0 ÷ 10 V | Voltage on Analog input 2 |
| analog3_volt | read | 0 ÷ 10 V | Voltage on Analog input 3 |
| analog4_volt | read | 0 ÷ 10 V | Voltage on Analog input 4 |
| RF_mode | read - write | 0, 1 | Radio control RF<br/>0 – controlling<br/>1 – programing |
| RF_min | read - write | 0 ÷ 100 % | Radio control RF – min. setting |
| RF_max | read - write | 0 ÷ 100 % | Radio control RF – max. setting |
| is_RF | read - write | 0, 1 | Radio control RF<br/>0 – not installed<br/>1 – installed |
| RF_value | read - write | 0 ÷ 100 % | Radio control RF – set point |
| RF_negative | read - write | 0, 1 | Radio control RF<br/>0 – positive<br/>1 – negative



## How to install.

Download `org.openhab.binding.comfoair-1.13.0.jar` file from this repository.<br/>

**Important !** If you use the original *binding.comfoair*, you must uninstall it before substituting the new .jar file (Paper UI > Add-ons > Bindings > ComfoAir - uninstall).

The *binding.comfoair* installation can be done in two ways:
1. Upload the `org.openhab.binding.comfoair-1.13.0.jar` file to the `openhab\addons` directory.
- openhab: `\openHAB\addons`
- openhabian: `/usr/share/openhab2/addons`
2. Copy the `org.openhab.binding.comfoair-1.13.0.jar` file to the directory in which the original *binding.comfoair* is located:
- openhab: `\openHAB\userdata\tmp\mvn\org\openhab\binding\org.openhab.binding.comfoair`
- openhabian: `/var/lib/openhab2/tmp/mvn/org/openhab/binding/org.openhab.binding.comfoair/1.13.0`<br/><br/>
Confirm overwriting of the original file.<br/>
If the original file is in a version other than 1.13.0, the name of the copied file should be renamed to the original *binding.comfoair* .jar file name.

Now you can install ComfoAir binding (Paper UI > Add-ons > Bindings > ComfoAir - install).

### The description below is very similar to the original *ComfoAir binding* readme file by Holger Hees.

## Binding Configuration

You can configure this binding in the file `services/comfoair.cfg`.

| Property | Default | Required | Description |
|----------|---------|:--------:|-------------|
| port     |         |   Yes    | Serial port which is connected to the Zehnder ComfoAir system, for example `/dev/ttyS0` on Linux or `COM1` on Windows |
| refresh  | 60000   |   No     | refresh inverval in milliseconds


### Example

```
port=/dev/ttyS0
```

## Item Configuration

The syntax of the binding configuration strings accepted is the following:

```
comfoair="<command>"
```

where `<command>` should be replaced with the ComfoAir command from the list above.

## Limitations

- Either the ComfoAir binding or the CCEase Comfocontrol can be active, but not together.
- You must implement auto mode by yourself with rules. But it is more powerful.

## Rights to access the serial port

- Take care that the user that runs openHAB has rights to access the serial port
- On Ubuntu systems that usually means adding the user to the group "dialout", i.e. 

```shell
sudo usermod -a -G dialout openhab
```

if `openhab` is your user.

## Examples

items/comfoair.items

```
// Comfo Air
Group		ComfoAir			"ComfoAir"					<recu>		(devices)

// Temperatures chart
Group	comfoairTemps_Chart									<temperature>	(ComfoAir)
Number	comfoairTemps_Chart_Period		"Period"

// Delay
Switch	Delayed_Start

// Summer - Winter energy switch
Switch	EnergySummerTime

// External temperature, this parameter is read by other sensor or by weather station
Number	weatherN_Temperature			"External temperature [%.1f °C]"						<temperature>

// Control
Number	comfoairControl				"Activate"					<computer>	(ComfoAir)			{comfoair="activate"}
Number	comfoairFanLevel			"Ventilation level [%d]"			<chart>		(ComfoAir)			{comfoair="fan_level"}
Number	comfoairFanLevel_Message		"Ventilation level [%d]"			<chart>		(ComfoAir)
Number	comfoairFanMode				"Supply / Exhaust"				<fan_in>	(ComfoAir)
Number	comfoairFanMode_Message			"Supply / Exhaust [%d]"				<fan_in>	(ComfoAir)
Number	comfoairTargetTemperature_Message	"Comfort temperature [%.1f °C]"			<temperature>	(ComfoAir)
Number	comfoairErrorReset			"Error reset"					<service>	(ComfoAir)			{comfoair="error_reset"}
Number	comfoairFilterReset			"Filter reset"					<service>	(ComfoAir)			{comfoair="filter_reset"}
Number	comfoairMode				"Manual - Auto [%d]"				<controlMode>	(ComfoAir)
Switch	comfoairControl_Switch			"Activate"					<control>	(ComfoAir)
Number	comfoairFilterPeriod			"Filter period [%d weeks]"			<zegar>		(ComfoAir)			{comfoair="filter_period"}
Number	comfoairChimney				"Fire programme [%d]"				<climate>	(ComfoAir)			{comfoair="is_chimney"}
Number	comfoairPreheater			"Preheater [MAP(comfoair_is-not.map):%s]"	<climate>	(ComfoAir)			{comfoair="is_preheater"}
Number	comfoairCookerHood			"Extractor hood [MAP(comfoair_is-not.map):%s]"	<climate>	(ComfoAir)			{comfoair="is_cookerhood"}
Number	comfoairBypass				"Bypass [%d]"					<climate>	(ComfoAir)			{comfoair="is_bypass"}
Number	comfoairEWT				"EWT [%d]"					<climate>	(ComfoAir)			{comfoair="is_ewt"}
Number	comfoairEnthalpy			"Enthalpy [MAP(comfoair_enthalpy.map):%s]"	<climate>	(ComfoAir)			{comfoair="is_enthalpy"}

// Messages
String	comfoairError												(ComfoAir)			{comfoair="error_message"}
String	comfoairError_Message			"Messages [%s]"					<attention>	(ComfoAir)
Number	comfoairFilterRuntime											(ComfoAir)			{comfoair="filter_running"}
String	comfoairFilterRuntime_Message		"Filter time [%s]"				<clock>		(ComfoAir)
Number	comfoairFilterErrorI											(ComfoAir)			{comfoair="filter_error_intern"}
Number	comfoairFilterErrorE											(ComfoAir)			{comfoair="filter_error_extern"}
String	comfoairFrozenError
String	comfoairInletError

// State
Number	comfoairTargetTemperature		"Comfort temperature [%.1f °C]"			<temperature>	(ComfoAir)			{comfoair="target_temperatur"}
Number	comfoairOutdoorIncomingTemperature	"Inlet air temperature [%.1f °C]"		<temperature>	(ComfoAir, comfoairTemps_Chart)	{comfoair="outdoor_incomming_temperatur"}
Number	comfoairIndoorIncomingTemperature	"Supply air temperature [%.1f °C]"		<temperature>	(ComfoAir, comfoairTemps_Chart)	{comfoair="indoor_incomming_temperatur"}
Number	comfoairIndoorOutgoingTemperature	"Return air temperature [%.1f °C]"		<temperature>	(ComfoAir, comfoairTemps_Chart)	{comfoair="indoor_outgoing_temperatur"}
Number	comfoairOutdoorOutgoingTemperature	"Exhaust air temperature [%.1f °C]"		<temperature>	(ComfoAir, comfoairTemps_Chart)	{comfoair="outdoor_outgoing_temperatur"}
Number	comfoairIncomingFan			"Supply capacity [%d %%]"			<fan_in>	(ComfoAir)			{comfoair="incomming_fan"}
Number	comfoairOutgoingFan			"Exhaust capasity [%d %%]"			<fan_out>	(ComfoAir)			{comfoair="outgoing_fan"}
Number	comfoairEfficiency			"Efficiency [%.1f %%]"									<efficiency>	(ComfoAir)
Number	comfoairBypassMode			"Bypass [MAP(comfoair_bypass.map):%s]"		<climate>	(ComfoAir)			{comfoair="bypass_mode"}
Number	comfoairEWTMode 			"EWT [MAP(comfoair_on-off.map):%s]"		<climate>	(ComfoAir)			{comfoair="ewt_mode"}
Number	comfoairChimneyMode			"Fire programme [MAP(comfoair_on-off.map):%s]"	<climate>	(ComfoAir)			{comfoair="chimney_mode"}
Number	comfoairPreheaterMode			"Preheater [MAP(comfoair_on-off.map):%s]"	<climate>	(ComfoAir)			{comfoair="preheater_mode"}
Number	comfoairCookerHoodMode			"Extractor hood [MAP(comfoair_on-off.map):%s]"	<climate>	(ComfoAir)			{comfoair="cookerhood_mode"}
Number	comfoairEnthalpyMode			"Enthalpy [MAP(comfoair_on-off.map):%s]"	<climate>	(ComfoAir)			{comfoair="enthalpy_mode"}
Number	comfoairFreezeMode			"Freeze [MAP(comfoair_freeze.map):%s]"		<climate>	(ComfoAir)			{comfoair="freeze_mode"}
```

transform/comfoair_bypass.map

```
1=Opened
0=Closed
undefined=unknown
-=unknown
```

transform/comfoair_on-off.map

```
1=On
0=Off
undefined=unknown
-=unknown
```

transform/comfoair_freeze.map

```
1=Frozen
0=OK
undefined=unknown
-=unknown
```

persistence/rrd4j.persist

```
Strategies {
	// for rrd charts, we need a cron strategy
	everyMinute : "0 * * * * ?"
}

Items {
	comfoairTemps_Chart : strategy = everyChange, restoreOnStartup
	comfoairEfficiency : strategy = everyMinute, restoreOnStartup
	comfoairFanLevel : strategy = everyMinute, restoreOnStartup
}
```

sitemaps/comfoair-demo.sitemap

```
sitemap ComfoAir-demo label="ComfoAir" {
	Frame label="Main" {
		Text item=comfoairError_Message labelcolor=[!="OK"="red"] valuecolor=[!="OK"="red"]
		Switch item=comfoairControl mappings=[0="CCEasy", 1="Komputer"]
		Switch item=comfoairErrorReset mappings=[1="Reset"]
		Switch item=comfoairFilterReset mappings=[1="Reset"]
	}
	Frame label="Control" {
		Switch item=comfoairMode mappings=[0="Manual", 1="Auto"]
		Switch item=comfoairFanMode_Message mappings=[0="Sup + Exh", 1="Supply", 2="Exhaust"]
		Switch item=comfoairFanLevel_Message mappings=[2="Level 1", 3="Level 2", 4="Level 3"]
		Setpoint item=comfoairTargetTemperature_Message step=0.5 minValue=15 maxValue=28 valuecolor=["black"]
	}
	Frame label="State" {
		Text item=comfoairOutdoorIncomingTemperature valuecolor=["black"]
		Text item=comfoairOutdoorOutgoingTemperature valuecolor=["black"]
		Text item=comfoairIndoorIncomingTemperature valuecolor=["black"]
		Text item=comfoairIndoorOutgoingTemperature valuecolor=["black"]
	}
	Frame {
		Text item=comfoairIncomingFan valuecolor=["black"]
		Text item=comfoairBypassMode valuecolor=["black"]
		Text item=comfoairOutgoingFan valuecolor=["black"]
		Text item=comfoairEWTMode valuecolor=[0="silver", 1="black"]
		Text item=comfoairEfficiency valuecolor=["black"]
		Text item=comfoairFreezeMode valuecolor=[0="black", 1="red"]
		Text item=comfoairFilterRuntime_Message valuecolor=["black"]
		Text item=comfoairChimneyMode valuecolor=[0="silver", 1="black"]
	}
	Frame label="Results" {
		Text label="Charts" icon="graph" {
			Chart item=comfoairTemps_Chart period=D refresh=10000
			Chart item=comfoairTemps_Chart period=W refresh=60000
			Chart item=comfoairTemps_Chart period=M refresh=60000
			Chart item=comfoairTemps_Chart period=Y refresh=600000
		}
	}
}
```

rules/comfoair-demo.rules

```Xtend
import java.lang.Math

var boolean autoChangeInProgress = false

rule "Filterlaufzeit"
when
    System started
    or
    Item Lueftung_Filterlaufzeit changed
then
    if( Lueftung_Filterlaufzeit.state instanceof DecimalType ){

        var Number laufzeit = Lueftung_Filterlaufzeit.state as DecimalType

        var Number weeks = Math::floor( (laufzeit/168).doubleValue )
        var Number days = Math::floor( ((laufzeit-(weeks*168))/24).doubleValue)

        var String msg = ""

        if( weeks > 0 ){

            if( weeks == 1 ) msg = weeks.intValue + " Woche"
            else msg = weeks.intValue + " Wochen"
        }

        if( days > 0 ){

            if( msg.length > 0 ) msg = msg + ", "

            if( days == 1 ) msg = msg + days.intValue + " Tag"
            else msg = msg + days.intValue + " Tage"
        }

        postUpdate(Lueftung_Filterlaufzeit_Message,msg)
    }
end

rule "Status Meldung"
when
    System started
    or
    Item Lueftung_Fehlermeldung changed
    or
    Item Lueftung_FilterfehlerI changed
    or
    Item Lueftung_FilterfehlerE changed
then
    var String msg = ""

    if( (Lueftung_FilterfehlerI.state instanceof DecimalType) && (Lueftung_FilterfehlerE.state instanceof DecimalType) && (Lueftung_Fehlermeldung.state instanceof StringType) ){

        if( (Lueftung_FilterfehlerI.state as DecimalType) == 1 || (Lueftung_FilterfehlerE.state as DecimalType) == 1 ){
            if( msg.length > 0 ) msg = msg + ", "
            msg = msg + "Filter: "
            if( (Lueftung_FilterfehlerI.state as DecimalType) == 1 ) msg = msg + "I"
            if( (Lueftung_FilterfehlerI.state as DecimalType) == 1 && (Lueftung_FilterfehlerE.state as DecimalType) == 1) msg = msg + " & "
            if( (Lueftung_FilterfehlerE.state as DecimalType) == 1 ) msg = msg + "E"
        }
        if( (Lueftung_Fehlermeldung.state as StringType) != "Ok" ){
            if( msg.length > 0 ) msg = msg + ", "
            msg = msg + "Error: " + (Lueftung_Fehlermeldung.state as StringType)
        }
    }

    if( msg.length == 0 ){

        msg = "Alles in Ordnung"
    }

    postUpdate(Lueftung_Status_Message,msg)
end

rule "Aussentemperatur Meldung"
when
    System started
    or
    Item Lueftung_Aussenlufttemperatur changed
    or
    Item Lueftung_Fortlufttemperatur changed
then
    if( (Lueftung_Aussenlufttemperatur.state instanceof DecimalType) && (Lueftung_Fortlufttemperatur.state instanceof DecimalType) ){

        postUpdate(Lueftung_Aussentemperatur_Message,"→ " + Lueftung_Aussenlufttemperatur.state.format("%.1f") +"°C, ← " + Lueftung_Fortlufttemperatur.state.format("%.1f") + "°C")
    }
end

rule "Innentemperatur Meldung"
when
    System started
    or
    Item Lueftung_Zulufttemperatur changed
    or
    Item Lueftung_Ablufttemperatur changed
then
    if( (Lueftung_Zulufttemperatur.state instanceof DecimalType) && (Lueftung_Ablufttemperatur.state instanceof DecimalType) ){

        postUpdate(Lueftung_Innentemperatur_Message,"→ " + Lueftung_Zulufttemperatur.state.format("%.1f") +"°C, ← " + Lueftung_Ablufttemperatur.state.format("%.1f") + "°C")
    }
end

rule "Ventilator Meldung"
when
    System started
    or
    Item Lueftung_Zuluft changed
    or
    Item Lueftung_Abluft changed
then
    if( (Lueftung_Zuluft.state instanceof DecimalType) && (Lueftung_Abluft.state instanceof DecimalType) ){

        postUpdate(Lueftung_Ventilator_Message,"→ " + (Lueftung_Zuluft.state as DecimalType) +"%, ← " + (Lueftung_Abluft.state as DecimalType) + "%")
    }
end

rule "Filter Fehler"
when
    Item Lueftung_Fehlermeldung changed
then
    if( (Lueftung_Fehlermeldung.state as StringType) != "Ok" ){

        send("test@gmail.com", "Lüftung hat einen Fehler gemeldet")
    }
end

rule "Filter wechseln"
when
    Item Lueftung_FilterfehlerI changed
    or
    Item Lueftung_FilterfehlerE changed
then
    if( (Lueftung_FilterfehlerI.state as DecimalType) == 1 || (Lueftung_FilterfehlerE.state as DecimalType) == 1 ){

        send("test@gmail.com", "Lüftungsfilter muss gewechselt werden")
        }
end

rule "Manueller Eingriff"
when
    Item Lueftung_Fan_Level changed
then

    if( autoChangeInProgress ){

        autoChangeInProgress = false
    }
    else{

        postUpdate(Lueftung_Auto_Mode,0)
    }
end

rule "Lüfterstufe"
when
    Item Lueftung_Auto_Mode changed
    or
    Time cron "0 0/1 * * * ?"
then
    if( (Lueftung_Auto_Mode.state as DecimalType) == 1 ){

        var Number day    = now.getDayOfWeek
        var Number hour   = now.getHourOfDay
        var Number minute = now.getMinuteOfHour

        var boolean isNight = false

        // Freitag
        if( day == 5 ){
            if( hour < 7 || (hour >= 23 && minute >=30) ) isNight = true
        }
        // Samstag
        else if( day == 6 ){
            if( hour < 9 || (hour >= 23 && minute >=30) ) isNight = true
        }
        // Sonntag
        else if( day == 7 ){
            if( hour < 9 || (hour >= 22 && minute >=30) || hour >= 23 ) isNight = true
        }
        else{

            if( hour < 7 || (hour >= 22 && minute >=30) || hour >= 23 ) isNight = true
        }

        var Number currentLevel = (Lueftung_Fan_Level.state as DecimalType)
        var Number newLevel = 3

        if( !isNight ){

            var Number raumTemperatur = (Lueftung_Ablufttemperatur.state as DecimalType)
            var Number aussenTemperatur = (Lueftung_Aussenlufttemperatur.state as DecimalType)
            var Number zielTemperatur = (Lueftung_Komfortemperatur.state as DecimalType)

            if(
                raumTemperatur >= zielTemperatur
                &&
                aussenTemperatur >= raumTemperatur
            ){

                newLevel = 1
            }
            else if(
                raumTemperatur >= zielTemperatur - 1
                &&
                aussenTemperatur >= raumTemperatur - 1
                &&
                currentLevel == 1
            ){

                newLevel = 1
            }
        }
        else if( Fenster_OG_Schlafzimmer.state == CLOSED || Fenster_OG_Ankleide.state == OPEN ) {

            newLevel = 2
        }

        if( newLevel != currentLevel ){

            if( newLevel == 1 ){

                logInfo("airflow.rules", "auto slowdown start")
                    send("test@gmail.com", "Lüftung verlangsamt")
            }
            else if( currentLevel == 1 ){

                    logInfo("airflow.rules", "auto slowdown end")
                send("test@gmail.com", "Lüftung wieder normal")
            }

            autoChangeInProgress=true
            sendCommand(Lueftung_Fan_Level,newLevel)
        }
    }
end
```
