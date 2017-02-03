from bs4 import BeautifulSoup
import urllib

''' program to scrape first definition off dictionary.com 
of given words, then write words w/ defs to given file.'''

def get_dirty_def(word):
    # give full url to new soup object, make instance, return div text
    url_concat = "http://www.dictionary.com/browse/" + word
    soup_input = urllib.urlopen(url_concat).read()
    soup = BeautifulSoup(soup_input, "lxml")
    return str(soup.find('div', class_="def-content").get_text(strip=True))

def format_online_def(bare_extracted_text):
    # strip 'example' by splicing up to ':',
    # return definition w/ capit. first letter and period ('formatted')
    index_of_colon = 0
    for i in bare_extracted_text:
        if (i==':'):
            break
        index_of_colon += 1
    return str.upper(bare_extracted_text[0]) + bare_extracted_text[1:index_of_colon] + "."

def string_def(the_word):
    # return full str w/ word and def.
    return str.upper(the_word[0]) + the_word[1:] + '\n' + format_online_def(get_dirty_def(the_word)) + '\n'

running_input = ""
end_set = ""
print "Welcome. Enter words to find (lowercase), 'quit' to finish."
file_to_write = raw_input("File to write to: ")
file_to_write = open(file_to_write + '.txt','w')

while (running_input!='quit'):
    running_input = raw_input("Give word to soup: ")
    if (running_input!='quit'):
        end_set = end_set + string_def(running_input)
    end_set += '\n'

file_to_write.write(end_set)
file_to_write.close()
print "...Done."
