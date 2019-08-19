import groovy.text.SimpleTemplateEngine

def text = 'Dear "$firstname $lastname",\nSo nice to meet you in <% print city %>.\nSee you in ${month},\n${signed}'

def binding = ["firstname":"Sam", "lastname":"Pullara", "city":"San Francisco", "month":"December", "signed":"Groovy-Dev"]

def engine = new SimpleTemplateEngine()
def template = engine.createTemplate(text).make(binding)


def right={a->
    println(a);
}

static def turn(a){
    return right
}



turn "left" then "right"
