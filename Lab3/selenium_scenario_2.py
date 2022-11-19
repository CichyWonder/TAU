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
logger.info('Przechodzę na stronę onet.pl')
driver.get('https://onet.pl/')
cookies = driver.find_element(By.XPATH, "//div[@id='rasp_cmp']/div/div[6]/button[2]/span")
logger.info('Klikam: Przejdź do serwisu')
cookies.click()
logger.info('Przechodzę na stronę wiadomości')
driver.get('https://przegladsportowy.onet.pl/')
driver.find_element(By.XPATH, "/html/body/div[1]/header/div[2]/div/div[2]/div[1]/div/input").click()
driver.find_element(By.XPATH, "/html/body/div[1]/header/div[2]/div/div[2]/div[1]/div/input").send_keys("onet")
driver.implicitly_wait(5)
driver.find_element(By.CLASS_NAME, 'MenuIcon_icon__ac4PH').click()
driver.find_element(By.LINK_TEXT, "Onet – Jesteś na bieżąco").click()
driver.implicitly_wait(5)
driver.find_element(By.XPATH,'/html/body/div[1]/header/div/div[2]/div[1]/a[6]').click()
driver.find_element(By.ID, "email").send_keys("yhym@gites.pl")
driver.find_element(By.ID, "password").send_keys("1234")
driver.find_element(By.XPATH, "//div[@id='__next']/main/div/div/div/div/div/div/div[2]/form/div[2]/div/button/span").click()
try:
    l = driver.find_element(By.CLASS_NAME, "sc-c4c71639-3 cnKcGk")
    s = l.text
    logger.info("Nieprawidłowy email lub hasło.")
except NoSuchElementException:
    logger.info("Brak elementu.")
driver.close()


