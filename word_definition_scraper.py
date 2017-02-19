from bs4 import BeautifulSoup
import urllib

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
    return str.upper(the_word[0]) + the_word[1:] + '\n' + "Definition: " + format_online_def(get_dirty_def(the_word)) + '\n'

def part_of_speech(the_word):
    url_concat = "http://www.dictionary.com/browse/" + the_word
    soup_input = urllib.urlopen(url_concat).read()
    soup = BeautifulSoup(soup_input, "lxml")
    grabbed = str(soup.find('span', class_="dbox-pg").get_text(strip=True))
    return str.upper(grabbed[0]) + grabbed[1:] + '\n'

# necessary stuff lies above; change block commenting below to switch between 
# inputting a list, and typing in words one-at-a-time

# generate doc by taking each word: 
'''
running_input = ""
end_set = ""
bulleted_num = 1
print "Welcome. Enter words to find (lowercase), 'quit' to finish."
file_to_write = raw_input("File to write to: ")
file_to_write = open(file_to_write+'.txt','w')


while (running_input!='quit'):
    running_input = raw_input("Give word to soup: ")
    if (running_input!='quit'):
        end_set = end_set + str(bulleted_num) + ". " + string_def(running_input)
        end_set += "Part of speech: " + part_of_speech(running_input)
        bulleted_num += 1
    end_set += '\n'
'''

# generate doc by inputting a list (place words in alpha_words; 
# use online alpha or browser-based word organizer to give correct ',' 
# separator to each word quickly if needed): 
alpha_words = ['abdicated','abolish','abolishing','absolved','abuses','accustomed','acquiesce','allegiance','alter','annihilation','appealed','appropriations','arbitrary','assent','barbarous','brethren','candid','charters','conjured','consent','constrained','constrains','convulsions','depository','depriving','deriving','desolation','despotism','destructive','dictate','disavow','disposed','dissolve','dissolved','emigration','endeavored','endowed','erected','establishment','evinces','excited','formidable','harass','impel','imposing','inestimable','institute','instituted','insurrections','invariably','invasion','invested','judiciary','jurisdiction','kindred','legislature','levy','magnanimity','merciless','mock','naturalization','obstructed','oppressions','perfidy','petitioned','plundered','province','prudence','quartering','ravaged','rectitude','redress','relinquish','render','subject','sufferable','suspending','tenure','transient','tyranny','unalienable','unwarrantable','usurpations','wholesome']
bulleted_num = 1;
end_set = ""
current_word = ""
iterator = 0
print "Definitions will output in 'out.txt'."
while (iterator < len(alpha_words)):
    end_set = end_set + str(bulleted_num) + ". " + string_def(alpha_words[iterator])
    end_set += "Part of speech: " + part_of_speech(alpha_words[iterator])
    bulleted_num += 1
    iterator += 1
    end_set += '\n'
    
# end any block commenting here; all below is necessary 
    
file_to_write = open('out.txt', 'w')
file_to_write.write(end_set)
file_to_write.close()
print "...Done."
