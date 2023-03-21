-- we need to find a couple of tables which we can play around with and join rather than independent tables
CREATE TABLE IF NOT EXISTS most_subscribed_channels (
    index               INTEGER,
    channels_names      VARCHAR,
    channel_line        VARCHAR,
    brand_status        VARCHAR,
    subscribers         INTEGER,
    primary_language    VARCHAR,
    category            VARCHAR,
    country_name                 VARCHAR,
    );

COPY most_subscribed_channels
FROM 'curl "http://www.kaggle.com/datasets/rajkumarpandey02/list-of-most-subscribed-youtube-channels-in-world"'
DELIMITER ','
CSV HEADER;