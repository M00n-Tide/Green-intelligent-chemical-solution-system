-- Insert sample chemical data
INSERT INTO chem_catalog (chemical_name, cas_number, molecular_formula, create_time, record_status, category_code, hazard_level, storage_condition) VALUES
('Ethanol', '64-17-5', 'C2H5OH', CURRENT_TIMESTAMP, 'Enabled', 'ALCOHOL', 'Medium Risk', 'Cool dry place'),
('Sodium Hydroxide', '1310-73-2', 'NaOH', CURRENT_TIMESTAMP, 'Enabled', 'ALKALI', 'High Risk', 'Sealed dry place'),
('Sulfuric Acid', '7664-93-9', 'H2SO4', CURRENT_TIMESTAMP, 'Enabled', 'ACID', 'High Risk', 'Store in acid-resistant container'),
('Acetone', '67-64-1', 'C3H6O', CURRENT_TIMESTAMP, 'Enabled', 'KETONE', 'Medium Risk', 'Cool ventilated place'),
('Hydrochloric Acid', '7647-01-0', 'HCl', CURRENT_TIMESTAMP, 'Enabled', 'ACID', 'High Risk', 'Store in acid-resistant container');

-- Insert inventory data
INSERT INTO chem_inventory (catalog_id, inventory_quantity, storage_location, storage_temp, container_type, status, last_update_time) VALUES
(1, 500.0, 'Area A - Cabinet 1', 'Room Temperature', 'Glass Bottle', 'NORMAL', CURRENT_TIMESTAMP),
(2, 50.0, 'Area B - Cabinet 2', 'Room Temperature', 'Plastic Bottle', 'NORMAL', CURRENT_TIMESTAMP),
(3, 200.0, 'Area C - Hazardous Storage', 'Room Temperature', 'Acid-Resistant Container', 'NORMAL', CURRENT_TIMESTAMP),
(4, 300.0, 'Area A - Cabinet 3', 'Room Temperature', 'Glass Bottle', 'NORMAL', CURRENT_TIMESTAMP),
(5, 150.0, 'Area C - Hazardous Storage', 'Room Temperature', 'Acid-Resistant Container', 'NORMAL', CURRENT_TIMESTAMP);

-- Insert safety data sheets
INSERT INTO safety_datasheet (chem_id, version, effective_date, document_path, file_format, status, created_by, created_time) VALUES
(1, 'v1.0', CURRENT_DATE, '/documents/sds_ethanol.pdf', 'PDF', 'Effective', 'System Administrator', CURRENT_TIMESTAMP),
(2, 'v1.0', CURRENT_DATE, '/documents/sds_naoh.pdf', 'PDF', 'Effective', 'System Administrator', CURRENT_TIMESTAMP),
(3, 'v1.0', CURRENT_DATE, '/documents/sds_sulfuric.pdf', 'PDF', 'Effective', 'System Administrator', CURRENT_TIMESTAMP),
(4, 'v1.0', CURRENT_DATE, '/documents/sds_acetone.pdf', 'PDF', 'Effective', 'System Administrator', CURRENT_TIMESTAMP),
(5, 'v1.0', CURRENT_DATE, '/documents/sds_hydrochloric.pdf', 'PDF', 'Effective', 'System Administrator', CURRENT_TIMESTAMP);

-- Insert experiment designs
INSERT INTO experiment_design (design_name, creator_id, created_date, status, experiment_steps, reagents, safety_notes) VALUES
('Organic Synthesis Experiment', 1, CURRENT_TIMESTAMP, 'Approved', '1. Prepare reaction container\n2. Add reactants\n3. Control temperature\n4. React for 2 hours\n5. Separate products', 'Ethanol, Sulfuric Acid', 'Wear protective equipment throughout, maintain ventilation'),
('Material Analysis Experiment', 2, CURRENT_TIMESTAMP, 'Submitted', '1. Sample collection\n2. Dissolve\n3. Titrate\n4. Record data', 'Hydrochloric Acid, Distilled Water', 'Protect eyes and skin'),
('Catalyst Testing', 3, CURRENT_TIMESTAMP, 'Draft', '1. Prepare catalyst\n2. Add reactants\n3. Heat reaction\n4. Test products', 'Acetone, Sodium Hydroxide', 'Control temperature, avoid overheating');

-- Insert experiment records
INSERT INTO experiment_record (design_id, executor_id, exec_time, result, used_reagents) VALUES
(1, 1, CURRENT_TIMESTAMP, 'Successfully produced target product, purity 95%', 'Ethanol 100ml, Sulfuric Acid 50ml'),
(2, 2, CURRENT_TIMESTAMP, 'Test results meet expectations', 'Hydrochloric Acid 20ml, Distilled Water 200ml');

-- Insert risk analysis
INSERT INTO risk_analyzer (chem_id, risk_type, risk_level, analysis_time, suggestion) VALUES
(1, 'Flammability', 3, CURRENT_TIMESTAMP, 'Keep away from fire sources, store in cool ventilated place'),
(2, 'Corrosivity', 4, CURRENT_TIMESTAMP, 'Avoid skin contact, wear protective equipment'),
(3, 'Strong Corrosivity', 5, CURRENT_TIMESTAMP, 'Professional operation, strict protective measures'),
(4, 'Flammability', 3, CURRENT_TIMESTAMP, 'Keep away from fire sources, use explosion-proof equipment'),
(5, 'Corrosivity', 4, CURRENT_TIMESTAMP, 'Avoid inhalation, use ventilation equipment');

-- Insert risk monitoring
INSERT INTO risk_monitor (analyzer_id, monitor_status, last_check_time, threshold) VALUES
(1, 'Running', CURRENT_TIMESTAMP, 'Temperature>30°C'),
(2, 'Running', CURRENT_TIMESTAMP, 'Humidity>80%'),
(3, 'Alert', CURRENT_TIMESTAMP, 'Concentration>10ppm'),
(4, 'Running', CURRENT_TIMESTAMP, 'Temperature>25°C'),
(5, 'Stopped', CURRENT_TIMESTAMP, 'Pressure>1atm');

-- Insert experiment cost data
INSERT INTO experiment_cost (experiment_record_id, cost_category, item_name, unit_price, quantity, total_cost, currency, created_time) VALUES
(1, 'Reagents', 'Ethanol', 5.25, 0.1, 0.525, 'USD', CURRENT_TIMESTAMP),
(1, 'Equipment', 'Glass Beaker', 12.50, 1, 12.50, 'USD', CURRENT_TIMESTAMP),
(1, 'Labor', 'Lab Technician', 25.00, 2, 50.00, 'USD', CURRENT_TIMESTAMP),
(2, 'Reagents', 'Hydrochloric Acid', 3.75, 0.05, 0.1875, 'USD', CURRENT_TIMESTAMP),
(2, 'Equipment', 'pH Meter', 150.00, 1, 150.00, 'USD', CURRENT_TIMESTAMP),
(2, 'Consumables', 'Test Tubes', 0.75, 10, 7.50, 'USD', CURRENT_TIMESTAMP);

-- Insert experiment data
INSERT INTO experiment_data (experiment_record_id, parameter_name, parameter_unit, measurement_value, expected_value, deviation, measurement_time, data_type) VALUES
(1, 'Temperature', '°C', 25.5, 25.0, 0.5, CURRENT_TIMESTAMP, 'Numeric'),
(1, 'Temperature', '°C', 26.0, 25.0, 1.0, TIMESTAMPADD(MINUTE, 5, CURRENT_TIMESTAMP), 'Numeric'),
(1, 'Temperature', '°C', 24.8, 25.0, -0.2, TIMESTAMPADD(MINUTE, 10, CURRENT_TIMESTAMP), 'Numeric'),
(1, 'Pressure', 'kPa', 101.3, 101.3, 0.0, CURRENT_TIMESTAMP, 'Numeric'),
(1, 'Pressure', 'kPa', 101.5, 101.3, 0.2, TIMESTAMPADD(MINUTE, 5, CURRENT_TIMESTAMP), 'Numeric'),
(1, 'Reaction Yield', '%', 92.5, 90.0, 2.5, TIMESTAMPADD(HOUR, 2, CURRENT_TIMESTAMP), 'Numeric'),
(2, 'pH Level', '', 7.2, 7.0, 0.2, CURRENT_TIMESTAMP, 'Numeric'),
(2, 'pH Level', '', 7.1, 7.0, 0.1, TIMESTAMPADD(MINUTE, 5, CURRENT_TIMESTAMP), 'Numeric'),
(2, 'pH Level', '', 7.0, 7.0, 0.0, TIMESTAMPADD(MINUTE, 10, CURRENT_TIMESTAMP), 'Numeric'),
(2, 'Conductivity', 'μS/cm', 150.0, 150.0, 0.0, CURRENT_TIMESTAMP, 'Numeric'),
(2, 'Conductivity', 'μS/cm', 152.5, 150.0, 2.5, TIMESTAMPADD(MINUTE, 5, CURRENT_TIMESTAMP), 'Numeric');