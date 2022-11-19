from selenium import webdriver
from selenium.common import NoSuchElementException
from selenium.webdriver.chrome.service import Service
import logging

from selenium.webdriver.common.by import By

logger = logging.getLogger('simple_example')
logger.setLevel(logging.INFO)
ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
ch.setFormatter(formatter)
logger.addHandler(ch)

driver = webdriver.Chrome(service=Service('/usr/local/bin/chromedriver'))
logger.info('Przechodzę na stronę Teufel')
driver.get('https://sklepmuzyczny.pl')
sale = driver.find_element(By.ID, 'category-115')
logger.info('Klikam w zakładkę słuchawki')
sale.click()
driver.implicitly_wait(5)
driver.find_element(By.XPATH, "/html/body/main/section/div/div[2]/section/section/div[4]/div/div/div[1]/div[5]/article").click()
logger.info('Superlux HD681')
driver.implicitly_wait(5)
driver.find_element(By.XPATH, "/html/body/main/section/div[1]/div/section[1]/div[3]/div[2]/div/div[2]/div/form/div[2]/div[1]/div[2]/button").click()
driver.get("https://sklepmuzyczny.pl/koszyk?action=show")
try:
    driver.find_element(By.XPATH, "/html/body/main/section/div/div/section/div/div[1]/div/div[2]/ul/li")
    logger.info("Element znajduje się w koszyku")
except NoSuchElementException:
    logger.error("Test failed.")
driver.close()
