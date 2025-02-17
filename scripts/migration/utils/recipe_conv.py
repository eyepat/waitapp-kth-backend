import json
import requests

api_url = 'https://waback.app.cloud.cbh.kth.se/api/recipe'
response = requests.get(api_url)

if response.status_code == 200:
    data = response.json()

    java_list = "List.of(\n"
    for i, item in enumerate(data):
        title = item["title"].replace('"', '\\"')
        description = item["description"].replace('"', '\\"')
        imageURL = item["imageURL"].replace('"', '\\"')
        url = item["url"].replace('"', '\\"')

        if i == len(data) - 1:
            java_list += f'    Recipe.builder().URL("{url}").cookingTime({item["cookingTime"]}).description("{description}").imageURL("{imageURL}").title("{title}").build()\n'
        else:
            java_list += f'    Recipe.builder().URL("{url}").cookingTime({item["cookingTime"]}).description("{description}").imageURL("{imageURL}").title("{title}").build(),\n'

    java_list += ')'

    print(java_list)
else:
    print(f"Failed to fetch data. Status code: {response.status_code}")
